package 题.树;

import 二叉树.TreeNode;
import 队列.LinkedListQueue;

import java.util.LinkedList;
import java.util.Stack;

public class 根据后缀表达式构造树 {
    public static void main(String[] args) {

        //原理，用栈 遇到数字入栈，遇到运算符出栈建立节点关系

        String[] str = {"2","1","-","3","*"};
        Stack<TreeNode> stk = new Stack<>();

        for(int i = 0;i<str.length;i++){
            //如果是数字，包装成树，入栈
            if(Character.isDigit(str[i].charAt(0))){
                stk.push(new TreeNode(str[i]));
                //如果不是数字，出栈然后建立关系
            }else{
                TreeNode right = stk.pop(); //栈顶右孩子
                TreeNode left = stk.pop();  //下一个左孩子
                TreeNode parent = new TreeNode(str[i]); //当前操作符当作当前树的根节点
                //把根节点和左右节点连接起来
                parent.right=right;
                parent.left=left;

                //再次把整个root入栈，然后进行下一次循环，因为可能这个根节点只是整个数的一个子节点
                stk.push(parent);
            }
        }

        print(stk.peek());

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
