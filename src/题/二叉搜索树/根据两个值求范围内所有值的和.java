package 题.二叉搜索树;

import 二叉搜索树.BSTNode;

import java.util.Stack;

public class 根据两个值求范围内所有值的和 {
    public static void main(String[] args) {
        //建树
        BSTNode<Integer, String> root = new BSTNode<>(4, "4",
                new BSTNode<>(2, "2",
                        new BSTNode<>(1, "1"),
                        new BSTNode<>(3, "3")),
                new BSTNode<>(6, "6"));

        System.out.println(print(root,2,4));
    }

    /*有优化空间 可以进行剪枝递归 当节点小于min就说明左边肯定不在范围内了 那么就直接拿右边 同理大于也是一样*/
    public static int print(BSTNode root,int min,int max){
        //中序遍历打印
        BSTNode p = root;
        Stack<BSTNode> stk= new Stack<>();
        int sum = 0;
        while(p!=null || !stk.isEmpty()){
            if(p!=null){
                stk.push(p);
                p=p.left;
            }else{
                BSTNode pop = stk.pop();

                if(Integer.parseInt((String)pop.value) >=min && Integer.parseInt((String)pop.value) <=max){
                    sum++;
                }

                p=pop.right;
            }
        }
        return sum;
    }
}
