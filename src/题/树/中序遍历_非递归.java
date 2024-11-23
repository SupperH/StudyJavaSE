package 题.树;

import 二叉树.TreeNode;

import java.util.Stack;

/*中序遍历代码逻辑和前序遍历完全一样，只是打印值的位置不一样，
* 前序遍历再前面打印，也就是深入树的时候打印
* 中序遍历在后面打印，也就是回溯树的时候打印*/
public class 中序遍历_非递归 {
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
                node.push(curr);
                curr=curr.left;
                //当当前节点没值说明这个分支到头了，那么就从栈中
                //弹出元素挪动到右子树，
                /*挪动到右子树后下一次循环又会进入到第一个if逻辑判断
                * 如果有值自然会输出当前节点右树，因为是往返走所以从栈中
                * 拿出内容并且直接输出右边是正确的*/
            }else{
                //左边结束返回
                TreeNode pop = node.pop();
                /*中序遍历后打印，回溯树的时候顺序打印即可*/
                System.out.println(pop.val);
                curr = pop.right;
            }

        }
    }
}
