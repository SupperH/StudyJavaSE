package 练习;

import java.util.Arrays;

public class 归并排序练习 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8,9};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    static void sort(int[] arr ,int left, int right){
        if(left == right) return;
        int mid = (left+right)/2;
        sort(arr,left,mid); //左
        sort(arr,mid+1,right);

        merge(arr,left,mid+1,right);
    }

    static void merge(int[] arr,int leftPtr,int rightPtr,int rightBound){

        int mid = rightPtr-1;

        int left = leftPtr;
        int right = rightPtr;


        int k = 0;
        int[] temp = new int[rightBound-left+1];

        while(left <= mid && right<=rightBound){
            if(arr[right] < arr[left]){
                temp[k] = arr[right];
                k++;
                right++;
            }else{
                temp[k] = arr[left];
                k++;
                left++;
            }
        }

        while(right <= rightBound){
            temp[k] = arr[right];
            right++;
            k++;
        }

        while(left <= mid){
            temp[k] = arr[left];
            left++;
            k++;
        }

        for(int i = 0;i<temp.length;i++){
            arr[leftPtr+i] = temp[i];
        }
    }
}
