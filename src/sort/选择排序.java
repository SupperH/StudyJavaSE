package sort;

import java.util.Arrays;

//基础排序之一 最简单但是最没用的排序算法  也有优化空间
public class 选择排序 {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,6,9};

        //原理是每次循环找一个最小值 然后把最小值放到最前面
        for(int i = 0;i<arr.length;i++){
            //存放最小值的下标
            int minipos = i;
            //循环i后面的值 然后进行比较 每次获得一个最小值然后交换
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<arr[minipos]){
                    //替换位置
                    int temp =arr[minipos];
                    arr[minipos] =arr[j];
                    arr[j] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(arr));

    }
}
