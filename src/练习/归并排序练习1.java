package 练习;

import java.util.Arrays;

public class 归并排序练习1 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8,9};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    static void sort(int[] arr ,int left, int right){
        //两边
        if(left ==right) return;
        int mid=(left+right) / 2;
        sort(arr,left,mid);
        sort(arr,mid+1,right);



        merge(arr,left,mid+1);
    }

    static void merge(int[] arr,int leftPtr,int rightPtr){

        int mid=rightPtr-1;
        int l = leftPtr;
        int r = rightPtr;
        int[] temp =new int[arr.length-1-leftPtr+1];

        int i = 0;
        while(l<=mid && r <=arr.length-1){
            if(arr[l] < arr[r]){
                temp[i] =arr[l];
                l++;
                i++;
            }else{
                temp[i] =arr[r];
                r++;
                i++;
            }
        }

        while(l <= mid){
            temp[i] =arr[l];
            i++;
            l++;
        }

        while(r<=arr.length-1){
            temp[i] =arr[r];
            i++;
            r++;
        }
        for(int j = 0;j<temp.length;j++){
            arr[leftPtr+j] = temp[j];
        }
        System.out.println(Arrays.toString(temp));

    }
}
