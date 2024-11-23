package 练习;

import java.util.Arrays;

public class 手撕快排912 {
    public static void main(String[] args) {
        int[] arr = {110,100,0};




        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr , int leftBound , int rightBound){
        if(rightBound <= leftBound) return;

        //一开始直接拿最后一个当轴 然后再根据返回的值递归动态修改轴，最后一个参数就是轴
        int pivot = exchange(arr, leftBound, rightBound);

        sort(arr,leftBound,pivot-1);
        sort(arr,pivot+1,rightBound);


    }

    //根据轴进行排序 并且返回最新的轴，当第一次以后调用方法返回的轴所在位置会在每次排序的数组的中间
    public static int exchange(int[] arr ,int leftBound,int rightBound){

        int pivotValue = arr[rightBound];
        int left = leftBound;
        int right = rightBound-1;

        while(left <=right){

            while(left <=right && arr[left] <=pivotValue){
                left++;
            }
            while(left <=right && arr[right] >pivotValue){
                right--;
            }

            if(left < right){
                swap(arr,left,right);
            }
        }

        //返回轴 交换完以后 left所在的位置就是轴应该在的位置了
        swap(arr,left,rightBound);
        return left;

    }
    static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
