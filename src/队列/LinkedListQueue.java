package 队列;

import java.util.Iterator;

public class LinkedListQueue<E>
        implements Queue<E>, Iterable<E> {

    //内部类
    private static class Node<E>{
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    //这里使用双向环形链表，首尾相连带哨兵

    Node<E> head=new Node<>(null,null);   //头 带哨兵
    Node<E> tail=head;   //尾
    int size;//节点数
    int capacity=Integer.MAX_VALUE;//容量(没指定那么默认就是最大的integer)

    //可以用代码块，把需要初始化的代码放进去，这样一加载就会执行
    {
        //首位相连
        tail.next=head;

    }

    public LinkedListQueue(int capacity){
        //初始化容量，如果调用了有参构造器
        this.capacity=capacity;
    }

    public LinkedListQueue(){
    }

    @Override
    //往链表插入数据
    public boolean offer(E value) {
        //如果容量满了，就没法添加了
        if(isFull()){
            return false;
        }
        //因为是环形链表，每次插入的值next都要指向头部，因为每次插入的值都要
        //当作最后一个值
        Node<E> added = new Node<>(value, head);
        //然后把尾部节点挪动到插入的值
        tail.next=added;
        tail=added;
        size++; //每次加入内容都要让元素数递增
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        //先拿到下一个节点，然后让头节点指向下一个节点的节点即可
        Node<E> first = head.next;
        head.next=first.next;
        //如果要挪开的节点是伪节点说明队列只有一个值了，那么要指向头部
        if(first==tail){
            tail=head;
        }
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        //不为空直接用链表获取值然后返回就行了 因为peek不用一处内容
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        //如果头部和尾部一样，说明链表没内容
        return head==tail;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    //实现一个迭代器
    public Iterator<E> iterator(){
        return new Iterator<E>() {
            Node<E> p = head.next;
            @Override
            public boolean hasNext() {
                return p!=head;
            }

            @Override
            public E next() {
                E value = p.value;
                p=p.next;
                return value;
            }
        };
    }



}
