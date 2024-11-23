package 题.树;

import 二叉树.TreeNode;
import 队列.LinkedListQueue;

public class 二叉树最大深度_层序遍历 {
    public static void main(String[] args) {
        //创建二叉树：
        TreeNode root = new TreeNode(
                new TreeNode(2),

                1,

                new TreeNode(null,
                        3,
                        new TreeNode(4))) ;


        //首先把二叉树放入队列
        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);

        //初始化层数，从第一层开始，就为1
        int c1=1;
        //存放深度
        int deep = 0;
        while(!queue.isEmpty()){
            //下一层节点数
            int next = 0;

            //循环节点数，第一次进来循环根节点默认循环一次
            for(int i = 0;i< c1;i++){
                //从队列中拿出值输出
                TreeNode node = queue.poll();
                System.out.print(node.val);

                //分别判断左右两边还有没有值有在压入队列然后让节点数+1以便下次循环
                if(node.left!=null){
                    queue.offer(node.left);
                    next++;
                }

                if(node.right!=null){
                    queue.offer(node.right);
                    next++;
                }

            }
            System.out.println();
            //把节点数赋给c1，因为next每次要清零
            c1=next;
            //用来计算深度的
            deep++;

        }
        System.out.println(deep);
    }
}
