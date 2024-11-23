package 二叉树;

import java.util.Stack;

public class 前序遍历_非递归 {
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

        //保存根的节点，先循环完左边然后再返回到根节点循环右边后面要用
        //使用栈记录来时的路，从栈里取值
        TreeNode curr =root;
        Stack<TreeNode> node = new Stack<>();
        //当当前当前节点有值，或者栈中还有内容，说明还没有探索完
        while(curr!=null|| !node.isEmpty()){

            //如果节点不为空，直接输出当前节点值，
            //然后放入栈，并且让节点移动到左子树
            if(curr!=null){
                System.out.println(curr.val);
                node.push(curr);
                /*因为前序遍历顺序是根左右，所以先诺到左边*/
                curr=curr.left;

                //当当前节点没值说明这个分支到头了，那么就从栈中
                //弹出元素挪动到右子树，
                /*挪动到右子树后下一次循环又会进入到第一个if逻辑判断
                * 如果有值自然会输出当前节点右树，因为是往返走所以从栈中
                * 拿出内容并且直接输出右边是正确的*/
            }else{
                //左边结束返回
                TreeNode pop = node.pop();
                curr = pop.right;
            }

        }
    }
}
