package 题.堆;

import 堆.MinHeap;

//跟求数组的基本类似，区别在于数据流的数字数量不确定 需要不断调用方法
public class 求数据流第k大的元素_小顶堆 {
    private static MinHeap maxHeap;

    public static void main(String[] args) {
        int k = 2;
        maxHeap=new MinHeap(k);
        System.out.println(add(3));
        System.out.println(add(5));
        System.out.println(add(10));
        System.out.println(add(9));
        System.out.println(add(4));
        System.out.println(add(3));

    }

    //数组中只会存在两个值，所以按照这样子每次只要是大于堆顶的替换，不大于的直接忽略
    public static int add(int val){
        //如果堆没满，需要直接往里面放数据
        if(!maxHeap.isFull()){
            maxHeap.offer(val);
        }
        else if(val > maxHeap.peek()){
            maxHeap.replace(val);
        }
            return maxHeap.peek();
    }
}
