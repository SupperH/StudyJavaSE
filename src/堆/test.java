package 堆;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        MaxHeap maxHeap = new MaxHeap(arr);
        System.out.println(Arrays.toString(maxHeap.array));
    }
}
