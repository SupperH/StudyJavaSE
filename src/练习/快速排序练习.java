package 练习;

import java.util.Arrays;

public class 快速排序练习 {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,2,10,8,1,9,5,4,6};
        System.out.println(Arrays.toString(arr));
        sort(arr,0,arr.length-1);

        //先拿到轴，然后依次让左边小于等于轴，右边大于等于轴，然后将轴移动到最后比较的位置

    }

    static void sort(int[] arr ,int leftBound,int rightBound){
        if(leftBound >=rightBound ) return;

        int pivot = exchange(arr,leftBound,rightBound);

        //排序左边
        sort(arr ,leftBound,pivot-1);
        //排序右边
        sort(arr ,pivot+1,rightBound);


    }

    static int exchange(int[] arr ,int leftpre,int rightpre){
        //轴
        int pivot = arr[rightpre];

        int left = leftpre;
        int right = rightpre-1;

        while(left <= right){
            while( left <=right && arr[left] <=pivot){
                left++;
            }
            while( left <=right && arr[right] >=pivot){
                right--;
            }
            if(left < right){
                swap(arr,left,right);
                System.out.println("移动后内容："+Arrays.toString(arr));
            }
        }
        //交换完左边右边还要把轴挪到中间
        swap(arr,left,rightpre);
        System.out.println("目标："+left);

        System.out.println("轴移动后："+Arrays.toString(arr));
        return left;

    }
    static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
