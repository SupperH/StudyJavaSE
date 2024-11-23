package 题.堆;

import 堆.MaxHeap;

import java.util.Arrays;

public class 堆排序 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        MaxHeap maxHeap = new MaxHeap(arr);
        System.out.println(Arrays.toString(maxHeap.array));

        //让建好的堆从小到大进行排序
        //原理，每次交换堆顶元素和最后一个元素循环
        while(maxHeap.size>1){
            //因为建好的堆，原理上就是从大到小建立的，所以直接把大的挪到最后
            maxHeap.swap(0, maxHeap.size-1);
            //然后size--目的是缩小排序范围
            maxHeap.size--;
            //down方法目的是让堆保持平衡，让大的浮到顶部，这样每次只要交换顶部和底部就行了
            maxHeap.down(0);
        }
        System.out.println(Arrays.toString(maxHeap.array));
    }
}
