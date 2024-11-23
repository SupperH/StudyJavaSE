package 题.树;

import 二叉树.TreeNode;

public class 前中后序遍历_递归 {
    public static void main(String[] args) {
        //创建二叉树：
       TreeNode root = new TreeNode(
               new TreeNode(new TreeNode(4),
               2,
               null),

               1,

               new TreeNode(new TreeNode(5),
                       3,
                       new TreeNode(6))) ;

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);

    }

    //前序遍历规则：先访问该节点，然后左子树，然后右子树
    static void preOrder(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.val+" ");
        //先打印左边
            preOrder(node.left);
        //再打印右边 因为递归实现，左边打完后node又会变成node一开始的位置
            preOrder(node.right);

    }

    //中 先访问左子树，然后该节点，最后右子树
    static void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        //递归先把左边到最深的地方，然后输出，
        //然后再返回到最初的时候，执行right，然后把右子树的左边深入到最下然后输出
        inOrder(node.left); //左
        System.out.print(node.val+" ");//值
        inOrder(node.right);//右
    }

    //后 先左，然后右，然后该节点
    static void postOrder(TreeNode node){
        if(node == null){
            return;
        }
        //同理 先深入左边，因为当node==null的时候就会停止，那么下面的node.right会直接return，然后输出值
        //当左边结束后，node实际上还是在最初位置，这时才执行right，right则同理
        postOrder(node.left); //左
        postOrder(node.right);//右
        System.out.print(node.val+" ");//值
    }
}
