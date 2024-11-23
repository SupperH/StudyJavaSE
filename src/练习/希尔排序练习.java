package 练习;

import java.util.Arrays;

public class 希尔排序练习 {
    //用希尔排序进行排序
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,6,9,10,18,19,20};

        //从第二个数开始判断往前插入
        for(int gap = 4; gap>0;gap = gap/2){
            //外循环i条件为i=gap内循环取i的值赋给j
            for(int i = gap;i<arr.length;i++){
                //根据间隔，取值
                for(int j = i;j>=gap;j-=gap){
                    //直接用j取值 不涉及到i了
                    if(arr[j] < arr[j-gap]){
                        int temp =arr[j-gap];
                        arr[j-gap] = arr[j];
                        arr[j]=temp;
                    }
                }
            }

        }
        System.out.println(Arrays.toString(arr));
    }

}
