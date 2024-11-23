package 题.链表;

/*
* 简述：
* 二分查找要求是一个有序的内容，不限于数组
* 原理是 设置两个节点，一个最左有个最右，
* 每次循环获取两个节点的中间值，判断要查找的内容是大于中间值还是小于中间值
* //如果小于 那么
*
* */
public class 二分查找递归实现 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10,11};
        int num = 11;

        //初始化左边节点
        int l = 0;
        //初始化右边节点
        int r = arr.length-1;

        //初始化中间节点
        int m = (l+r)>>>1;
        int result = sort(arr,11,l,r,m);
        System.out.println(result);

    }

    static int sort(int[] arr,int num,int l,int r,int m){
        //找到了就返回
        if(num == arr[m]){
            return m;
        }
        //当左节点小于右边节点才循环，否则就是已经查找完内容了
            //如果数字小于中间值，说明在num在中间值的左边
            if(num < arr[m]){
                //把右节点挪到中间值前一位，重新计算中间节点
                r = m-1;
                m=(l+r)>>>1;
                //递归实现，继续调用自身循环判断,因为每次调用都有可能得到结果，所以要顺便return
                return sort(arr,11,l,r,m);
                //同理，num在中间值的右边
            }else if(num > arr[m]){
                //同理，移动左节点
                l=m+1;
                m=(l+r)>>>1;
                //同理
                return sort(arr,11,l,r,m);
            }
            //默认返回-1，如果上面都没返回说明就不存
                return -1;
    }
}
