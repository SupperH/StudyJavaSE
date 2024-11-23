package 题.树;

import 二叉树.TreeNode;

/*
对称二叉树结构：
*               1
*       2               2
*   3       4       4       3
* 5   6   7   8    8  7    6  5

* */
public class 对称二叉树 {
    public static void main(String[] args) {
        //创建二叉树：
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(6),
                        2,
                        new TreeNode(5)),

                1,

                new TreeNode(new TreeNode(5),
                        2,
                        new TreeNode(6))) ;
        check(root.left,root.right);

    }


    public static boolean check(TreeNode left,TreeNode right){
        //如果两个节点都为null 那么说明要么整个树只有一个根节点
        //要么已经整棵树已经递归比较完毕，可以返回true了
        if(left==null &&right == null){
            System.out.println(true);
            return true;
        }

        //如果一边为null一边不为null那么不是对称二叉树，返回false
        if(left==null || right==null){
            return false;
        }
        //如果两边节点值不相等，那么也返回false
        if(left.val!=right.val){
            return false;
        }
        //上述逻辑是所有节点都需要经历的，那么要处理后面所有的节点，只需要递归即可
        //当整棵树走完说明第二三个if都没满足那么会直接return true在方法一开始
        //又因这里做了个并且操作需要同时满足左右两边子树都相等，所以可以达到判断所有节点的逻辑
        return check(left.left,right.right) && check(left.right,right.right);
    }
}
