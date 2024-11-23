package 题.树;

/*深度的定义:从根出发，离根最远的节点总边数
*   注意：leetcode上的深度定义要在这个基础上加1*/

import 二叉树.TreeNode;

import java.util.Stack;

/**
 * 深度1(leetcode:2)     深度2(leetcode：3)
 *  1                        1
 *2   3                    2    3
 *                                4

 */

/*非递归：后序遍历，栈的最大高度就是最大深度*/
public class 二叉树最大深度_非递归 {
    public static void main(String[] args) {
        //创建二叉树：
        TreeNode root = new TreeNode(
                new TreeNode(2),

                1,

                new TreeNode(null,
                        3,
                        new TreeNode(4)));

        TreeNode curr = root;
        Stack<TreeNode> node = new Stack<>();
        TreeNode pop = null;
        int max = 0;
        while (curr != null || !node.isEmpty()) {
            //处理左子树
            if (curr != null) {
                node.push(curr);

                //直接定义一个值，每次判断当前值是否小于当前栈高度，如果小于
                //重新赋值为当前栈高度即可

                /*因为栈的高度，在逻辑中会不断变化
                * 但是在弹出栈之前，栈的高度肯定会达到某一个分支的
                * 最大深度，所以可以直接这么判断*/
                if(max<node.size()){
                    max = node.size();
                }
                curr = curr.left;
            } else {
                TreeNode peek = node.peek();
                if(peek.right==null || peek.right==pop){

                    pop = node.pop();
                }else{
                    curr=peek.right;
                }
            }
        }
        System.out.println(max);
    }

}
