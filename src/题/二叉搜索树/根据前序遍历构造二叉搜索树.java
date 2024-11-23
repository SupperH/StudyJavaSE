package 题.二叉搜索树;

import 二叉搜索树.BSTNode;
import 二叉搜索树.BSTTree;
import 二叉树.TreeNode;

import java.util.Stack;

public class 根据前序遍历构造二叉搜索树 {
    public static void main(String[] args) {

        int[] arr = {8,5,1,7,10,12};
        TreeNode treeNode = buildTree(arr);
        preOrder(treeNode);
    }

    public static TreeNode buildTree(int[] arr){
        //首先用数组第一位建树 因为前序遍历的第一个值肯定是整个数的根节点
        TreeNode root = new TreeNode(arr[0]);
        //从第二个数开始循环，每次循环插入一个值
        for(int i = 1;i<arr.length;i++){
            /*插入逻辑 关键点*/
            insert(root,arr[i]);
        }
        return root;
    }

    private static TreeNode insert(TreeNode root, int val) {

        /*使用递归实现，不需要循环 因为这个方法是在循环调用的 每次传入一个值*/
        //当root为null说明找到需要插入的位置了，那么把节点返回去开始归
        if(root == null){
            return new TreeNode(val);
        }
        //如果值小于当前节点值 说明应该放在左边，所以递归调用insert 把左边当作节点参数，然后返回的结果赋值给root的左孩子即可
        /*递归调用会多次判断 到最后肯定会走到上面的root==null 走到后就说明当前位置是需要插入的位置 那么直接return个节点 赋值给当前位置的root.left即可*/
        if(val < (int)root.val){
            root.left = insert(root.left,val);
        }else if(val > (int)root.val){
            root.right = insert(root.right,val);
        }
        return root;
    }


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
}
