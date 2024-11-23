package sort;


import java.util.Arrays;

/**
 * 桶排序的一种
 * 非比较排序
 * 多关键字排序
 * 空间复杂度o（n）时间复杂度o(n*k)
 */
public class 基数排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{421,430,115,532,305,240,124};


        int[] result = new int[arr.length];

        //跟计数排序一样，定义一个数组用下标代表数字
        //只要定义长度10就行了 因为基数排序是按照位数进行排序
        //每一位最大只到9
        int[] count = new int[10];

        //因为这里都是三位数，所以循环3次写死，否则要先知道位数最高是多少
        for(int i = 0;i<3;i++){
            //求10的几次方，后面获取位数要用
            int division = (int)Math.pow(10,i);

            System.out.println("当前数组内容"+Arrays.toString(arr));

            System.out.println("第"+i+"截出的数字分别为： ");
            for(int j=0;j<arr.length;j++){
                //根据division拿到位数
                int num = arr[j]/division%10;
                System.out.print(num+" ");
                //计数排序的思想，把num当作下标存入
                count[num]++;
            }
            System.out.println();

            System.out.println("第"+i+"位数对应出现的次数的下标"+Arrays.toString(count));


            //这个循环的作用是得到每个数应该在的对应位置上
            //下标代表数字，下标的值代表最后出现的位置，这个位置要减去1才是正确的位置
            //因为是从0开始
            // 如果有连续有值相等，说明那个下标对应的值出现的次数为0

            /**
             * 比如：
             * 第一次循环的时候
             * 1 0 5 2 5 0 4
             * 位数对应出现的次数的下标   [2, 1, 1, 0, 1, 2, 0, 0, 0, 0]
             * 数字应该出现的位数（没减一）[2, 3, 4, 4, 5, 7, 7, 7, 7, 7]
             * 0最后出现的位置在2，1最后出现的位置在3，2最后出现的位置在4，因为3值和2一样所以出现次数为0，4最后出现的位置在5 以此类推
             */
            for(int m = 1;m<count.length;m++){
                count[m] = count[m]+count[m-1];
            }
            System.out.println("数字应该出现的位数（没减一）"+Arrays.toString(count));


            //这里倒着循环数组的目的是，保证稳定性质，
            //比如 排序到最后， 当前数组内容[305, 115, 124, 421, 532, 430, 240]
            //数字出现位置[0, 2, 3, 4, 6, 7, 7, 7, 7, 7]
            //那么前两个数应该是 115和124
            //正着循环，先拿到115，然后放到--count[num]为1位置也就是第二位，然后第二次拿到124，这个时候--count[num]为0 也就是第一位 这样顺序明显就不对了
            for(int n = arr.length-1;n>=0;n--){
                //同样先获取对应位数的值
                int num= arr[n]/division%10;

                //将arr数组的值通过累加的数组，放到result对应的位置上去
                //因为count下标是值，内容是最后出现的位置，所以可以通过count[num]获取到要存放到的位置然后--是因为从0开始上面也说过 要减一才可以用
                //--是先减后用，同时当再次出现相同的数的时候，因为count中对应的值已经修改，所以也不存在覆盖数据的情况，只会继续往前插值
                result[--count[num]] =arr[n];

                System.out.println(Arrays.toString(result));

            }
            //每次移动好后，要将result的值复制到arr原数组，然后再继续排序，否则排完了跟没排一样。因为要将所有位数全部排完才行，而且每次排序要根据前一次位数排序的结果进行。
            System.arraycopy(result ,0,arr,0,arr.length);
            //因为每次比较位数count存的数据都不一样，所以每次重置里面的内容
            Arrays.fill(count,0);

            System.out.println("第"+i+"次排序后"+Arrays.toString(result));
            System.out.println();

        }

        System.out.println(Arrays.toString(result));

    }
}
