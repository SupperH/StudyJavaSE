package 练习;

import 二叉树.TreeNode;
import 队列.LinkedListQueue;

public class 遍历二叉树练习 {
    public static void main(String[] args) {

        TreeNode node = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )
        );

        LinkedListQueue<TreeNode>  treeNodes = new LinkedListQueue<>();

        treeNodes.offer(node);
        int c=1;
        while(!treeNodes.isEmpty()){
            int nextc=0;
            for(int i = 0;i<c;i++){
                TreeNode n = treeNodes.poll();
                System.out.print(n.val);
                if(n.left!=null){
                    treeNodes.offer(n.left);
                    nextc++;
                }
                if(n.right!=null){
                    treeNodes.offer(n.right);
                    nextc++;
                }
            }
            c=nextc;
            System.out.println();

        }
    }
}
