package 题.堆;

import 堆.MaxHeap;
import 堆.MinHeap;

import java.util.Arrays;

public class 求数组第k大的元素_小顶堆 {
    public static void main(String[] args) {
        findKthLargest(new int[]{3,2,1,5,6,4} , 2);
    }

    public static int findKthLargest(int[] numbers,int k){
        int large=0;
        MinHeap maxHeap = new MinHeap(k);
        //先向堆放入前k个元素
        for(int i = 0;i<k;i++){
            maxHeap.offer(numbers[i]);
        }
        //然后循环剩余内容，当数组中的值大于堆顶元素时，替换堆顶内容
        /*因为 求第k个最大的 之前已经插入了k个值到堆
        * 那么这里只需要拿到从大到小k个最大的值放入堆中，然后
        * 根据小堆顶的特性，和我们写的小堆顶的代码，父节点小于子节点
        * 这样当循环结束我们直接获取堆顶就达到了拿到第k大的数字*/
        for(int i = k;i<numbers.length;i++){
            if(numbers[i]>maxHeap.peek()){
                maxHeap.replace(numbers[i]);
            }
        }
        System.out.println(maxHeap.poll());

        return large;
    }
}
