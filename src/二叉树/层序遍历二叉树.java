package 二叉树;

import 队列.LinkedListQueue;

//广度优先遍历--层序遍历
//如果是数组实现的二叉树，直接遍历数组就是广度优先遍历了
public class 层序遍历二叉树 {
    public static void main(String[] args) {
        //创建如下图的树
        /*
                 1
              2      3
            4  5    6  7
         */
        TreeNode root = new TreeNode(
          new TreeNode(
                  new TreeNode(4),2,
                  new TreeNode(5)
          ),
                1,
          new TreeNode(
                  new TreeNode(6),3,
                  new TreeNode(7)
           )
        );

        //用自己实现的队列把树放进去
        LinkedListQueue<TreeNode> queue=new LinkedListQueue<>();
        queue.offer(root);

        int c=1;//当前层数
        //循环队列
        while(!queue.isEmpty()){
            int c2=0;//下一层节点数

            //为了让输出按照树的结构一层层输出，要加for和两个变量c和c2
            for (int i= 0;i<c;i++){
                //拿到队列的值然后用tree接收
                TreeNode n = queue.poll();
                System.out.print(n+" ");
                //如果有左节点就放入 这样再次循环的时候queue又有值了
                if(n.left!=null){
                    queue.offer(n.left);
                    c2++;
                }

                //同理
                if(n.right!=null){
                    queue.offer(n.right);
                    c2++;
                }
            }
           c=c2;
            System.out.println();
        }
    }
}
