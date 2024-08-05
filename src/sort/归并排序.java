package sort;

import java.util.Arrays;

//merge sort tim sort
//tim Sort 是mergesort的改进版
//在java中arrays工具类给对象进行排序用的就是TImSort
//可以点开源码看的
public class 归并排序 {

    //使用递归思想，把数组对半分然后排序，最后创建一个新数组
    //然后将对半分的数组相互比较，哪边小就先移到新数组，然后小的那边移动指针
    //继续比较，以此类推

    public static void main(String[] args) {
        int[] arr = {2,1,4,7,8,3,6,9};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    //if(0 == 7) return;
    //int mid = (0 + 7)/2;  3
    //sort(arr,0,3);
    //	右边排序挂起，先走完左边排序
    //	if(0 == 3) return;
    //	int mid = (0 + 3)/2;  1
    //	sort(arr,0,1);
    //		if(0 == 1) return;
    //		int mid = (0 + 1)/2;  0
    //		sort(arr,0,0);
    //			if(0 == 0) return;
    //			return后，再走左边排序
    //sort(arr,0+1,1);
    //	if(1 == 1) return;
    //	最后再走merge
    //以此类推
     static void sort(int[] arr,int left,int right){
        if(left == right) return;
       //分成两半把数组
       int mid = (left + right)/2;
       //左边排序
       sort(arr,left,mid);
       //右边排序
       sort(arr,mid+1,right);

       // 合并两个有序数组
       merge(arr,left,mid+1,right);


     }

    //可以灵活排序数组的那一部分，不仅仅是单纯的分一半，可能分一半的一半
    //rightbound代表当前数组循环的临界值，因为可能只要排序一部分所以
    //temp的长度也不能写死，这个是用作判断循环次数的
    static void merge(int[] arr,int leftPtr,int rightPtr , int rightBound){
        //先将数组分为两半
        //这里rightPtr-1就是当前要循环的数组的中间值
        //因为第二个数组开始是rightPtr，所以中间值就是rightPtr-1
        int mid = rightPtr-1;
        //创建新的数组存放排序好的数组
        int[] temp = new int[rightBound-leftPtr+1];

        int i = leftPtr;//第一个数组的初始位置
        int j = rightPtr; //第二个数组的初始位置
        int k= 0;//新数组的初始位置

        //当两个数组都没有遍历完，继续循环
        while(i<=mid && j <= rightBound){
            //判断排好序的两个数组哪边小，哪边小就挪哪边
            if (arr[i]<=arr[j]){
                temp[k] = arr[i];
                i++;
                k++;
            }else{
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        //如果上述操作做完，还有某一边数组还存在内容，那么就说明剩下的数组
        //都是最大的几个 直接挪到新数组后面就行
        while(i<=mid){
            temp[k] = arr[i];
            k++;
            i++;
        }
        while(j <= rightBound){
            temp[k] = arr[j];
            k++;
            j++;
        }

        // 将排序好的临时数组复制回原数组
        //在归并排序中，每次合并后，我们需要将临时数组 temp
        // 中的已排序结果复制回原数组 arr，
        // 这是因为排序操作是递归进行的，
        // 后续的合并操作依赖于之前部分已正确排序的数组。
        // 如果不将 temp 的内容放回原数组，下一次递归合并时，
        // 原数组中的数据可能仍是未排序的，从而导致最终排序结果不正确。
        for (int m = 0; m < temp.length; m++) {
            arr[leftPtr + m] = temp[m];
        }

    }


}
