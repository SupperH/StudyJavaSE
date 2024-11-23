package 题.树;

/*深度的定义:从根出发，离根最远的节点总边数
*   注意：leetcode上的深度定义要在这个基础上加1*/

import 二叉树.TreeNode;

/**
 * 深度1(leetcode:2)     深度2(leetcode：3)
 *  1                        1
 *2   3                    2    3
 *                                4
 *
 *
 *
 *
 *
 */
/*思路：
* 得到左子树深度，得到右子树深度，二者最大加一，就是本节点深度
* 因为需要先得到左右树深度，很显然就是后续遍历典型应用*/
public class 二叉树最大深度_递归 {
    public static void main(String[] args) {
        //创建二叉树：
        TreeNode root = new TreeNode(
                new TreeNode(2),

                1,

                new TreeNode(null,
                        3,
                        new TreeNode(4))) ;

        System.out.println(maxdeep(root));

    }

    public static int maxdeep(TreeNode root){
        //如果当前节点是空，说明已经走到尽头，直接返回0
        if(root==null){
            return 0;
        }

        //把左右两边节点都拿到然后判断哪边大然后+1
        /*
        * 这两行代码会分别将当前节点的左边和右边分别走完
        * 然后分别return一个+1
        *
        * 执行顺序
        * 先把left循环完，root=2时，再次调用maxdeep
        * 就会归，return0，那么这个时候，root就变成了null
        * 因为当root=2的时候再次调用root.left得到的就是null，所以调用maxdeep传入的参数也是null
        * 那么这时再往下走，获取right得到的也会是0，因为root一直等于null，
        * 然后当判断right的执行完毕，return Integer.max(left,right)+1;时，
        * 再一次回到调用maxdeep(root.left)时，root才会有值，恢复成调用该方法时的root=1
        * 然后再同理，进行递归调用maxdeep(root.right)
        * 这时，会return三次Integer.max(left,right)+1
        * 第一次是节点4归 取得0，0 + 1 =1
        * 第二次是节点3归 取得 0，1 + 1 = 2
        * 最后一次就是根节点1归取得0,2 + 1 = 3
        *最终结果就是3
        * */
        int left = maxdeep(root.left);
        int right =maxdeep(root.right);

        //每个叶子节点的深度都是1，然后判断左右哪边大，取哪边递归相加即可。
        return Integer.max(left,right)+1;
    }
}
