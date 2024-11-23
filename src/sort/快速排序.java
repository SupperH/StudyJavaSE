package sort;

import java.util.Arrays;

/**
 * 快速排序原理：
 * 先指定一共轴，一般指定最后一个值为轴，然后进行递归对数组进行平分操作，每次根据轴对左右两边进行判断，
 * //左边的值要小于等于轴，右边的值要大于等于轴，比较完后将轴挪到中间，然后以此类推
 */
public class 快速排序 {
    public static void main(String[] args) {
        int[] arr = {6,8,9,4,3,2,7,1};

        sort(arr,0,arr.length-1);
    }
    static void sort(int[] arr , int leftBound, int rightBound){
        //如果只有一个元素,或者当交换，交换到右边已经超过左边了就结束 直接返回
        if(rightBound <= leftBound) return;

        int pivot = exchange(arr,leftBound,rightBound);
        //对左边进行排序
        sort(arr,leftBound,pivot-1);
        //对右边进行排序
        sort(arr,pivot+1,rightBound);

    }

    static int exchange(int[] arr , int leftBound,int rightBound){
        //轴的值
        int pivot = arr[rightBound];
        //左边指针
        int left = leftBound;
        //右边指针 从轴前一个开始
        int right = rightBound-1;

        //当左指针小于等于右指针的时候，说明还没有遍历完，继续循环
        //注意如果这里不写小于等于，那么只剩下两个数的时候会出错，因为最后分为一个长度为2的数组 实际上left和right是等于的
        //所以这里要小于等于，或者如果这里不写等于 要在最后swap的时候做一个if判断
        //        if(arr[left] > arr[rightBound]){
        //            swap(arr,left,rightBound);
        //
        //        }
        while(left <= right){
            //如果左边的值小于轴，说明这个值不需要移动，只需要移动指针位置就行 ， 如果大于了，那么就结束这个循环，然后在后面进行交换
            while(left <= right && arr[left] <= pivot){
                left++;
            }
            //同理 因为上面left已经小于等于pivot了 所以这里right应该是大于 而不是大于等于 否则相当于判断两次等于
            while(left <= right && arr[right] > pivot){
                right--;
            }

            //只有当左指针小于右指针的时候才交换，因为只有这个时候才没有遍历完，否则会将之前移动好的数据弄乱
            System.out.println("当前数组内容："+Arrays.toString(arr));
            if(left < right){
                swap(arr,left,right);
            }
        }
        System.out.println("交换后数组内容："+Arrays.toString(arr));

        //当所有值都移动完，要将轴，也就是最后一个值，跟左右的中间值交换，达到轴左边比他小，右边比他大的效果
        //因为left最后记录的位置就是一个大于pivot的值，所以将left和rightbound交换即可
            swap(arr,left,rightBound);

        System.out.println("轴是"+rightBound);
        System.out.println("移动轴数组内容："+Arrays.toString(arr));
        System.out.println();

        return left;
    }

    static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
