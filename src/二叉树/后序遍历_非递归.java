package 二叉树;

import java.util.Stack;

/**
 *      1
 *   2     3
 * 4   7  5  6
 *
 * 顺序：4725631
 *
 */
public class 后序遍历_非递归 {
    public static void main(String[] args) {
        //创建二叉树：
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4),
                        2,
                        new TreeNode(7)),

                1,

                new TreeNode(new TreeNode(5),
                        3,
                        new TreeNode(6))) ;

        //保存根的节点，先循环完左边然后再返回到根节点循环右边后面要用
        //使用栈记录来时的路，从栈里取值
        TreeNode curr =root;
        TreeNode pop = null; //记录最近一次弹栈
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
            }else{
             /*   后续遍历根节点是最后打印，
                 所以不能直接弹栈，
                 因为当前节点后面可能还需要，所以这里要做判断*/

                TreeNode peek = node.peek();    //拿到栈顶元素

                /*
                * 弹栈有两种条件，
                * 第一种是当节点没有右孩子，那么可以弹栈，因为左右都已经结束
                *   这种条件用于节点不存在右节点的时候
                * 第二种是上一次弹栈的节点和当前栈顶元素的右孩子一致，说明已经弹过了，那么也应该结束
                *   这种情况用于节点存在右节点，但是已经弹出过了
                * */
                if(peek.right==null|| peek.right==pop){

                    //如果没有右节点或者上一次已经弹出，那么就可以继续回溯，直接弹栈
                    /*
                    * 因为后序遍历当前节点是后于左右节点输出，而又因为
                    * 在上面入栈的时候右节点并没有入栈，所以这里需要进行判断
                    * 在下面的else把右边节点处理完毕后，然后再一次循环
                    * 该节点的右节点就不存在右节点了，这时候就可以弹出当前节点
                    *
                    * 并且输出，然后继续向后回溯
                    * */
                    //并且输出当前节点即可
                    pop = node.pop();
                    System.out.println(pop.val);
                /*如果存在右节点或者没有弹出过右节点，
                那么让当前循环的指针指向当前节点的右节点
                 继续循环*/
                }else{
                    curr = peek.right;
                }
            }

        }
    }
}
