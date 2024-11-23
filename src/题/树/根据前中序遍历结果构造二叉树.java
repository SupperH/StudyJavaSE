package 题.树;

import 二叉树.TreeNode;
import 队列.LinkedListQueue;

import java.util.Arrays;

//递归实现
/*
树：
        1
      2    3
     4   6  7

     pre:124367
     in:421637
 */
public class 根据前中序遍历结果构造二叉树 {

    public static void main(String[] args) {

        TreeNode treeNode = buildTree(new int[]{1, 2, 4, 3, 6, 7}, new int[]{4, 2, 1, 6, 3, 7});
        print(treeNode);

    }

    public static TreeNode buildTree(int[] pre,int[] in){
        //如果数组空了，那么就说明递归完了直接return null
        if(pre.length==0){
            return null;
        }


        //前序遍历的第一个值肯定是整个数的根节点，所以用根节点先建树
        int rootval = pre[0];
        TreeNode root = new TreeNode(rootval);

        //循环传入的表达式，循环谁都一样，因为两个表达式长度肯定是一样的
        for(int i = 0;i<pre.length;i++){

            //用中缀表达式来区分整个数的左边和右边，因为根据中缀表达式的规律，整个数的根节点在左右节点的中间
            if(rootval == in[i]){
                /*
                注意：可以不用创建新数组，只要把下面每个节点当作参数放到方法中传入即可，这里不做演示了
                 */
                //用中间的节点，分别拆分前缀和中缀表达式，将左右子树划分开来
                //Arays.copyOfRange是左开右闭，意思是左边的值会包含在取值内，但是右边的值不包含，所以这里写i实际上只会截取到i-1为止
                int[] inLeft = Arrays.copyOfRange(in, 0, i); //中缀表达式根节点左边是左子树
                int[] inRight = Arrays.copyOfRange(in, i+1, in.length); //同理，右子树

                //再把前缀表达式切分 前缀表达式，切分的范围可以根据中缀表达式来定
                int[] preLeft = Arrays.copyOfRange(pre, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(pre, i + 1, in.length);

                //然后递归分别把左子树和右子树求出来
                root.left = buildTree(preLeft,inLeft);
                root.right = buildTree(preRight,inRight);
            }
        }

        //将root返回，下次递归继续使用，如果结束了就直接正常返回
        return root;
    }
    public static void print(TreeNode root){

        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);

        int c=1; //每层要循环的次数，从根节点开始根节点循环一次
        while(!queue.isEmpty()){

            int c1 = 0; //下一层的节点数
            for(int i = 0;i<c;i++){
                TreeNode poll = queue.poll();
                System.out.print(poll.val+" ");

                if(poll.left!=null){
                    queue.offer(poll.left);
                    c1++;
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                    c1++;
                }
            }
            System.out.println();
            c=c1;
        }

    }
}
