package 双端队列;

import java.util.Iterator;

/*基于双向环形链表实现双端队列*/
public class LinkedListDeque<E> implements Deque<E> ,Iterable<E> {

    //迭代器，循环用的
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p= sentinel.next;//起点
            @Override
            public boolean hasNext() {
                return p!=sentinel;
            }

            @Override
            public E next() {
                E value = p.value;
                p=p.next;
                return value;
            }
        };
    }

    @Override
    public boolean offerFirst(E e) {
        if(isFull()){
            return false;
        }
        //双端队列 要获取到上一个节点和下一个节点
        //头部添加，那么added前面的就是哨兵 所以a是哨兵，b是哨兵的下一个
        //最后把添加的内容放到a和b中间即可
        Node<E> a = sentinel;
        Node<E> b=sentinel.next;
        Node<E> added = new Node<>(a,e,b);
        //这一步后， 就变成了 a added b 所以a的next和b的prev要指向e
        a.next=added;
        b.prev=added;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if(isFull()){
            return false;
        }

        //双端队列 要获取到上一个节点和下一个节点
        //尾部添加，那么b就是哨兵，a就是哨兵的上一个节点
        //最后把添加的内容放到a和b中间即可
        Node<E> a = sentinel.prev;
        Node<E> b=sentinel;
        Node<E> added = new Node<>(a,e,b);
        //最后跟offerFirst一样，重新把a和b的指向改为added
        a.next=added;
        b.prev=added;
        size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if(isEmpty()){
            return null;
        }
        //同样要找到要移除的上一个和下一个
        //由于是头部移除 那么a就是哨兵
        //要移除的元素在哨兵下一个，也就是next
        //b就算要移除的元素的下一个 就是remove.next
        Node<E> a = sentinel;
        Node<E> removed=sentinel.next;
        Node<E> b=removed.next;

        //然后修改两个节点的下一个和上一个相当于跳过了中间的值
        //达到remove效果
        a.next=b;
        b.prev=a;
        size--;
        return removed.value;
    }

    @Override
    public E pollLast() {
        if(isEmpty()){
            return null;
        }
        //同样要找到要移除的上一个和下一个
        //由于是尾部移除 那么b就是哨兵
        //要移除的元素在哨兵上一个，也就是prev
        //a就是要移除的元素的上一个 就是remove.prev
        Node<E> b=sentinel;
        Node<E> removed=sentinel.prev;
        Node<E> a = removed.prev;

        //然后修改两个节点的下一个和上一个相当于跳过了中间的值
        //达到remove效果
        a.next=b;
        b.prev=a;
        size--;
        return removed.value;
    }

    @Override
    public E peekFirst() {
        if(isEmpty()){
            return null;
        }
        //不移除的逻辑就很简单了 因为是头部，所以直接哨兵下一个值就行了
        return sentinel.next.value;
    }

    @Override
    public E peekLast() {
        //同理,查看最后一个就是哨兵前一个值
        return sentinel.prev.value;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size==capacity && size!=0;
    }

    //内部类
    private static class Node<E>{
        Node<E> prev;
        E value;
        Node<E> next;

        public Node(Node<E> prev, E value, Node<E> next) {
            this.prev=prev;
            this.value = value;
            this.next = next;
        }
    }

    //容量
    int capacity;
    //元素个数
    int size;
    //循环的链表
    Node<E> sentinel = new Node<>(null,null,null);

    public LinkedListDeque() {
        //初始化链表的头和尾为哨兵
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
    }

    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
        //初始化链表的头和尾为哨兵
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
    }
}