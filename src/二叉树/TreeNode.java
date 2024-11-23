package 二叉树;

//树节点类
public class TreeNode {
    public Object val;  //值
    public TreeNode left;//左节点
    public TreeNode right;//右节点

    public TreeNode(Object val){
        this.val=val;
    }

    public TreeNode(TreeNode left, Object val,  TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
