package 双端队列;
/*双端队列： 头部尾部都可以增加和删除数据*/
public interface Deque<E> {

    //头部插入
    boolean offerFirst(E e);
    //尾部插入
    boolean offerLast(E e);

    //头部删除
    E pollFirst();
    //尾部删除
    E pollLast();

    //头部查看
    E peekFirst();
    //尾部查看
    E peekLast();

    boolean isEmpty();

    boolean isFull();
}
