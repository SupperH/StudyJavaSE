package 练习;

import java.util.Arrays;

public class 基数排序练习 {
    public static void main(String[] args) {
        int[] arr = new int[]{421,430,115,532,305,240,124};

        int[] result = new int[arr.length];

        int[] position = new int[10];

        for(int i=0;i<3;i++){
            //求10的几次方，后面获取位数要用
            int division = (int)Math.pow(10,i);

            System.out.println("当前数组内容"+ Arrays.toString(arr));

            System.out.println("第"+i+"截出的数字分别为： ");
            for(int j=0;j<arr.length;j++){
                //根据division拿到位数
                int num = arr[j]/division%10;
                System.out.print(num+" ");
                //计数排序的思想，把num当作下标存入
                position[num]++;
            }

            System.out.println("数字出现次数"+Arrays.toString(position));

            //计算数字最后出现的次数
            for(int m = 1;m<position.length;m++){
                position[m] =position[m]+position[m-1];
            }
            System.out.println("数字出现位置"+Arrays.toString(position));

            //根据位数从原数组取值放到result
            for(int k = arr.length-1;k>=0;k--){
                //从position拿到数字出现的位置，放到result
                int num = arr[k]/division%10;
                result[--position[num]] = arr[k];
            }
            //做完后，把result值放到arr中，再循环
            System.arraycopy(result ,0,arr,0,arr.length);
            Arrays.fill(position,0);
        }

        System.out.println("最终结果"+Arrays.toString(result));
    }
}
