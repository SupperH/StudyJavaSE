package 题.栈;

import 队列.LinkedListQueue;

import java.util.Queue;
/*
* 思路:队列是先进先出 栈是先进后出
* 那么每次往队列里放内容，都要保证在队列的顶部
* 那么只需要每次放完后，把其他内容挪动到当前放入内容之后即可
*
* */
public class 单队列模拟栈 {
    //这里使用我们自定义的栈
    static LinkedListQueue<Integer> queue = new LinkedListQueue<>();

    //定义队列中元素数量，循环要用到
   static int size=0;


    public static void push(int x){
        queue.offer(x);

        //放完内容后，把之前内容取出然后重新放入队列 这样就达到了
        //之前内容在新放入内容之后的效果
        //因为size是在循环后++ 所以上一步offer的值不会在此次循环中
        for(int i = 0;i<size;i++){
            queue.offer(queue.poll());
        }
        size++;
    }

    public static void main(String[] args) {
        for(int i = 0;i<5;i++){
            push(i);
        }

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
