package 题.二叉搜索树;

import 二叉树.TreeNode;

/*包含自己*/
public class 两个节点最近公共祖先 {
    public static void main(String[] args) {
        //创建二叉树：
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(0),
                        2,
                        new TreeNode(4)),

                6,

                new TreeNode(new TreeNode(7),
                        8,
                        new TreeNode(9))) ;


        //如果p和q在某一结点的两侧，那么这个节点就是最近的公共祖先
        TreeNode p = new TreeNode(7);
        TreeNode q = new TreeNode(9);

        TreeNode parent = root;


        /*判断是否在同一侧*/
        while((int)p.val < (int)parent.val && (int)q.val < (int)parent.val || (int)p.val > (int)parent.val && (int)q.val > (int)parent.val){
            //根据二叉树特性 左右移动即可
            if((int)p.val < (int)parent.val){
                parent=parent.left;
            }else{
                parent=parent.right;
            }
        }

        System.out.println(parent.val);
    }

}
