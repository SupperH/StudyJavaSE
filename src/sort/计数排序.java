package sort;

import java.util.Arrays;

/**
 * 桶排序的一种
 * 非比较排序
 * 量大，但是范围小
 * 就是定义一个新数组，数组长度等于要排序的数组最大值的长度
 * 然后循环获取未排序的值，当作下标去找新数组对应的下标然后递加
 * 空间复杂度是n+k 很大，要根据实际情况考虑 比如对年龄进行排序1-100岁
 * 很方便但是如果数据值很大 比如10101111，那么就不合适了
 *
 * 目前这个写法是不稳定的排序
 */
public class 计数排序 {
    public static void main(String[] args) {
        //这个数组最大值为9 所以可以用计数排序
        int[] arr = {2,4,2,3,7,1,1,0,0,5,6,9,8,5,7,4,0,9};

        int[] result = new int[arr.length];
        //定义一个长度为10的数组取值0-9
        int[] temp = new int[10];
        for(int i = 0;i<arr.length;i++){
            //把值当作下标给temp对应的位置递加
            temp[arr[i]]++;
        }

        //定义一个index做下标
        int index = 0;
        for(int i = 0;i<temp.length;i++){
            for(int j = 0;j<temp[i];j++){
                //实际上i才是应该存的值，i对应的值只是出现的次数
                result[index] = i;
                index++;
            }
        }

        System.out.println(Arrays.toString(result));
    }
}
