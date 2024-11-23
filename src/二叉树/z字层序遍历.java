package 二叉树;

import 双端队列.LinkedListDeque;

/*
     1
  2      3
4  5    6  7
遍历顺序：
    1
    32
    4567

*/
public class z字层序遍历 {
public static void main(String[] args) {
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

    //放到我们自定义的双端队列中
    LinkedListDeque<TreeNode> node =new LinkedListDeque<>();

    node.offerFirst(root);

    int c =1;//当前层数
    int count=1;
    while(!node.isEmpty()){
        int c1=0;//下一层节点数
        //一开始肯定是循环一次 因为是root
        for(int i = 0;i<c;i++){
            TreeNode n= null;
            //z字形遍历很简单，基数从前面出，偶数从后面出就行了
            //这就是双端队列的特点，这里也可以使用jdk自带的linkedlist也是双端队列的形式
            if(count%2 != 0){
                 n = node.pollFirst();

            }else{
                 n = node.pollLast();

            }
            System.out.print(n.val+" ");

            if(n.left!=null){
                node.offerFirst(n.left);
                c1++;
            }
            if(n.right!=null){
                node.offerFirst(n.right);
                c1++;
            }
        }
        c=c1;
        count++;
        System.out.println();
    }
}

}
