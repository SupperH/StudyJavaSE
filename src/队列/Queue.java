package 队列;

public interface Queue<E> {

    /**
     * 向队列插入值
     * @param value 待插入值
     * @return成功true，失败false
     */
    boolean offer(E value);

    /**
     * 从队列头部获取值，并且移除
     * @return如果队列非空返回对头值，否则返回null
     */
    E poll();

    /**
     * 从队列头获取值，不移除
     * @return
     */
    E peek();

    //检查队列是否为空
    boolean isEmpty();

    //检查队列是否已满
    boolean isFull();
}
