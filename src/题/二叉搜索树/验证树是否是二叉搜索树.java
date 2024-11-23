package 题.二叉搜索树;

import 二叉搜索树.BSTNode;
import 二叉搜索树.BSTTree;

import java.util.Stack;

//98题
/*
合法 符合规律 左比根小，右比根大
*         4
*     2       6
*  1    3
*
不合法 没有满足规律
            5
        4       6
              3    7
*
* */
public class 验证树是否是二叉搜索树 {
    static int prev = -1;


    /*
    * 思路：
    * 根据搜索树的定义 左边所有内容都小于根节点，右边所有内容都大于根节点
    * 那么只需要进行中序遍历如果左节点小于根同时右节点大于根 那么就是搜索树
    *
    * */
    public static void main(String[] args) {
        //建树
        BSTNode<Integer, String> root = new BSTNode<>(4, "4",
                new BSTNode<>(2, "2",
                        new BSTNode<>(1, "1"),
                        new BSTNode<>(3, "3")),
                new BSTNode<>(6, "6"));

        check(root);
        boolean b = check2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(b);
        print(root);

    }

    public static void check(BSTNode root){
        //中序
        BSTNode p = root;
        Stack<BSTNode> stk= new Stack<>();
        int prev = -1; //上一个值
        while(p!=null || !stk.isEmpty()){
            if(p!=null){
                stk.push(p);
                p=p.left;
            }else{
                BSTNode pop = stk.pop();
                //如果上一个节点也就是左节点大于他的父节点 说明不满足 直接return
                /*因为中序排序是升序排序，所以上一个肯定是要比下一个小的，所以如果出现了大于的 那么直接return就行了 不是平衡二叉树*/
                if(prev > Integer.parseInt((String) pop.value)){
                    System.out.println("不是");
                    return;
                }
                //记录上一个节点就是当前节点
                prev = Integer.parseInt((String) pop.value);
                p=pop.right;


            }
        }
        System.out.println("是");
    }


    /*递归实现*/
    public static boolean checkrecursion(BSTNode root){
        if(root == null){
            return true;
        }

        boolean a = checkrecursion(root.left);
        if(prev > Integer.parseInt((String) root.value)){
            return false;
        }
        prev = Integer.parseInt((String) root.value);
        boolean b = checkrecursion(root.right);
        return a && b;
    }


    //根据上下限递归判断
    /*原理就是每个节点应该在一个范围内范围由上一个节点也就是父节点的值来决定 在范围内就true 不在就false*/

    public static boolean check2(BSTNode root,int ln,int rn){
        if(root ==null){
            return true;
        }
        if(Integer.parseInt((String)root.value) <=ln && Integer.parseInt((String)root.value)  >= rn){
            return false;

        }else{
            return check2(root.left,ln,Integer.parseInt((String)root.value)) &&
            check2(root.right,Integer.parseInt((String)root.value),rn);
        }


    }

    public static void print(BSTNode root){
        //中序遍历打印
        BSTNode p = root;
        Stack<BSTNode> stk= new Stack<>();
        while(p!=null || !stk.isEmpty()){
            if(p!=null){
                stk.push(p);
                p=p.left;
            }else{
                BSTNode pop = stk.pop();
                System.out.println(pop.value);
                p=pop.right;
            }
        }
    }
}
