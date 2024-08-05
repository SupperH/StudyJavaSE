package sort;

import java.util.Arrays;

public class 插入排序 {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,6,9};

        //跟冒泡排序很像 从第二个数开始循环，然后往前插
        for(int i = 1;i<arr.length;i++){
            //注意 插入排序内循环是从j=i开始，
            //然后递减比较，
            // 比如第一次循环一次，比较5 和4替换后 4 5 3 2 1 6 9
            //第二次循环两次 比较4 5 3 以此2类推
            for(int j = i;j>0;j--){
                //每次拿到当前值和前一个值进行比较，因为循环是从第二个开始
                //所以-1最少也等于0，所以没问题
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(arr));

    }
}
