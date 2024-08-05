package sort;

import java.util.Arrays;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,6,9};

        //每次循环比较自身和后面的元素 如果后面的比自己小 就替换位置
        for(int i = 0;i<arr.length;i++){
            for(int j = i+1;j<arr.length-1;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(arr));

    }
}
