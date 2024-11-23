package 题.树;

import 二叉树.TreeNode;
import 队列.LinkedListQueue;

public class 翻转二叉树_递归 {
    public static void main(String[] args) {
        //创建二叉树：
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(
                                new TreeNode(7),
                                4,
                                new TreeNode(5)

                        ),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(3));

        print(root);
        fn(root);
        System.out.println("-------------------");
        print(root);
    }

    //两边交换位置，操作逻辑都是一样的 所以递归即可
    public static void fn(TreeNode node){
        if(node == null){
            return;
        }
        TreeNode tmp = node.left;
        node.left=node.right;
        node.right = tmp;

        fn(node.left);
        fn(node.right);


    }

    public static void print(TreeNode root){

        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);

        int c=1; //每层要循环的次数，从根节点开始根节点循环一次
        while(!queue.isEmpty()){

            int c1 = 0; //下一层的节点数
            for(int i = 0;i<c;i++){
                TreeNode poll = queue.poll();
                System.out.print(poll.val+" ");

                if(poll.left!=null){
                    queue.offer(poll.left);
                    c1++;
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                    c1++;
                }
            }
            System.out.println();
            c=c1;
       }

    }
}
