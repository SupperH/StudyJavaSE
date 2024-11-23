package 练习;

import 二叉树.TreeNode;

import java.util.Stack;

public class 前中后遍历二叉树_非递归练习 {
    public static void main(String[] args) {
        //创建二叉树：
        //创建二叉树：
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4),
                        2,
                        new TreeNode(7)),

                1,

                new TreeNode(new TreeNode(5),
                        3,
                        new TreeNode(6))) ;

        pre(root);
        in(root);
        post(root);
    }

    public static void pre(TreeNode root){
        System.out.println("前序遍历");
        TreeNode curr = root;
        Stack<TreeNode> node = new Stack<>();
        while(curr!=null || !node.isEmpty()){
            //处理左子树
            if(curr!=null){
                //前序遍历用：
                System.out.print(curr.val+" ");
                node.push(curr);
                curr=curr.left;


            }else{
                TreeNode pop = node.pop();
                curr=pop.right;
            }

        }
    }

    public static void in(TreeNode root){
        System.out.println();
        System.out.println("中序遍历");
        TreeNode curr = root;
        Stack<TreeNode> node = new Stack<>();
        while(curr!=null || !node.isEmpty()){
            //处理左子树
            if(curr!=null){
                node.push(curr);
                curr=curr.left;


            }else{
                TreeNode pop = node.pop();
                System.out.print(pop.val+" ");
                curr=pop.right;
            }

        }
    }

    public static void post(TreeNode root){
        System.out.println();
        System.out.println("后序遍历");
        TreeNode curr = root;
        Stack<TreeNode> node = new Stack<>();
        TreeNode pop=null;
        while(curr!=null || !node.isEmpty()){
            //处理左子树
            if(curr!=null){
                node.push(curr);
                curr=curr.left;
            }else{
                //获取栈顶
                TreeNode peek = node.peek();
                if(peek.right==null || peek.right==pop){
                     pop = node.pop();
                    System.out.print(pop.val+" ");
                }else{
                    curr=peek.right;

                }

            }

        }
    }
}
