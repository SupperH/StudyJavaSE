package sort;

//merge sort tim ，sort
public class 归并排序 {

    //使用递归思想，把数组对半分然后排序，最后创建一个新数组
    //然后将对半分的数组相互比较，哪边小就先移到新数组，然后小的那边移动指针
    //继续比较，以此类推

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,6,9,24,15};

    }

    static void merge(int[] arr){
        //先将数组分为两半
        int mid = arr.length/2;
        //创建新的数组存放排序好的数组
        int[] temp = new int[arr.length];

        int i = 0;//第一个数组的初始位置
        int j = mid+1; //第二个数组的初始位置
        int k= 0;//新数组的初始位置

        //当两个数组都没有遍历完，继续循环
        while(i<=mid && j < arr.length){
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
        while(j<arr.length){
            temp[k] = arr[j];
            k++;
            j++;
        }

    }


}
