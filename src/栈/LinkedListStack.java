package 栈;


import java.util.Iterator;

public class LinkedListStack<E> implements Stack<E>,Iterable<E> {

    private int capacity; //容量
    private int size;//元素个数
    private Node<E> head = new Node<>(null,null);//头指针


    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }


    @Override
    public boolean push(E value) {
        if(isFull()){
            return false;
        }
        //每次添加数据都在头部后一个添加，然后让添加的节点下一个节点
        //指向原本head的下一个节点，达到头插法的效果
        //这样新插入的数据就会在前面后来循环就会先循环到
        //达到了栈先进后出的效果

        /*head->1
        *   add 2
        * head->2->1
        *
        * */
        head.next = new Node<>(value, head.next);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            return null;
        }
        //因为pop是要弹出元素，
        // 所以这里不但要拿出元素还要断开拿出元素的链接

        Node<E> first = head.next;
        head.next=first.next;
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        //peek不移除只获取，所以这么写就行了
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }



    static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next){
            this.value = value;
            this.next = next;
        }


    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            //头节点不循环，所以从头节点下一个开始循环
            Node<E> p=head.next;
            @Override
            public boolean hasNext() {
                return p!=null;
            }

            @Override
            public E next() {
                //循环p就行了
                E value =p.value;
                p=p.next;
                return value;
            }
        };
    }
}
