package sort;

import java.util.Arrays;
//希尔排序跟插入排序差别在，希尔排序多了一个
//变量用于存放间隔，后面的循环都是根据间隔来的
//每次比较前后间隔的两个数
public class 希尔排序 {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,6,9};
        //最佳的间隔序列是Knuth序列：
        //计算Knuth序列：死代码记得就行
        int h = 1;
        while(h<=arr.length/3){
            h = h*3+1;
        }
        //每次要缩小间隔，一直当gap为1的时候比较完，也就排好序了
        //for(int gap = 4;gap> 0;gap /=2){
        //for(int gap = arr.length /2;gap> 0;gap /=2){
        //使用Knuth序列
        for(int gap = h;gap> 0;gap =(gap-1)/3){

            //和插入排序不同的是，要从gap位开始比较
            //比如如果间隔是4，那么从第五个开始循环
            for(int i= gap;i < arr.length;i++){
                //内循环从j=i开始，每次循环后减去gap，说明
                //每次根据间隔进行比较
                for(int j = i;j>gap-1;j-=gap){
                    //替换也是替换间隔的两个数
                    //如果gap是4，第一次比较 下标为4和下标为0的数
                    //也就是比较1 5
                    //第二次外循环i++后，j=4+1=5
                    //那么就比较下标为5和下标为1的数字
                    //以此类推
                    if(arr[j] < arr[j-gap]){
                        int temp = arr[j-gap];
                        arr[j-gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
