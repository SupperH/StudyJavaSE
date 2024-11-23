package 二叉搜索树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
二叉搜索树和普通二叉树的区别在于 多了一个key值
每个跟节点的左节点都小于根，右节点都大于根，这是通过key值进行比较的

定义泛型，并且定义上限，只能是继承了comparable接口的类型，因为需要进行比较，java中只有继承comparable接口的类才能进行比较
值也可以定义成泛型，这样根hashmap就很类似了有键值
 */
public class BSTTree<K extends Comparable<K>,V> {



    BSTNode<K,V> root; //根节点

    //查找key对应的值,递归查找，根据二叉搜索树的特性，左边比根小右边比根大，只需要每次调用更改对应节点即可
    public Object get(K key){
        return doGet(root,key);
    }

    //递归调用的get方法 也可以不用递归用while循环做
    private Object doGet(BSTNode<K,V> node, K key){
        if(node == null){
            return null;  //没找到
        }
        //compareTo比较大小，如果小于0说明前小于后，大于0说明前大于后，等于0说明相等
        if(key.compareTo(node.key) < 0){
            return doGet(node.left,key);  //小于向左找
        }else if(key.compareTo(node.key) > 0){
            return doGet(node.right,key);  //大于向右找
        }else{
            return node.value; //找到了
        }

    }

    //查找最小key对应的值
    /*思路：根据搜索树的特性，左边比根小，那么只需要找到最左边的值就可以确定最小key对应的值了\
    * 也可以使用递归来做，但是这里我们使用迭代，因为上面get已经是递归了 多用几种方法
    * */
    public Object min(){
        BSTNode<K,V> node = root;

        while(node.left!=null){
            node = node.left;
        }
        return node.value;

    }
    /*从任意一个根节点开始 找其树的最小值*/
    public Object min(BSTNode p){
        BSTNode<K,V> node = p;

        while(node.left!=null){
            node = node.left;
        }
        return node.value;

    }

    //查找最大key对应的值
    /*根min同理，不做解释*/
    public Object max(){
        BSTNode<K,V> node = root;

        while(node.right!=null){
            node = node.right;
        }
        return node.value;

    }

    /*从任意一个根节点开始 找其树的最大值*/
    public Object max(BSTNode p){
        BSTNode<K,V> node = p;

        while(node.right!=null){
            node = node.right;
        }
        return node.value;

    }

    //存储关键字和对应值
    /*这里也可以直接调用get方法，但是这里我们用递归来进行查找key判断是否存在*/
    public void put(int key,Object value){

        //如果整个树是空的 那直接在这新建根节点即可
        if(root == null){
            root = new BSTNode(key,value);
            return;

        }

        BSTNode node = root;
        BSTNode parent = null;
        while(node !=null){
            /*每次循环开始前记录上一次节点所在位置，用作后续新增节点的父节点
            因为新增节点所在的位置就是while中最后一次判断后node赋值的位置，所以只需要得到赋值位置上一次节点就是他的父节点*/
            parent = node;
            //左边
            if(key < (int)node.key){
                node=node.left;
             //右边
            }else if(key > (int)node.key){
                node=node.right;
            //找到了
            }else{
                //1.key 有 直接更新当前位置的值然后return即可
                node.value=value;
            }
        }

        //2.key 没有 新增
        /*找到新节点的父节点，新增
        * 先判断是左孩子还是右孩子*/
        if(key < (int)parent.key){
            parent.left = new BSTNode(key,value);
        }else{
            parent.right = new BSTNode(key,value);

        }

    }

    //查找关键字的前任值
    public Object successor(int key){
        /*思路：先排序，然后根据值就可以得到前任值，直接中序遍历就是从小到大排列，这是搜索树的规则 但是性能不高，所以不用
        * 前任值是要比当前值小的，所以肯定是从左边找*/

        BSTNode p = root;

        //自左而来的祖先
        BSTNode ancestorFromLeft =null;
        while(p!=null){
            //左边
            if(key < (int)p.key){
                p=p.left;
                //右边
            }else if(key > (int)p.key){
                ancestorFromLeft = p;
                p=p.right;
            }else{
                break;
            }
        }

        //没找到节点
        if(p==null){
            return null;
        }

        //节点有左子树，前任就是左子树最大值
        if(p.left!=null){
            return max(p.left);
        }
        //没有左子树，若离他最近的，自左而来的祖先就是前任
        return ancestorFromLeft !=null?ancestorFromLeft.value:null;

    }

    //查找关键字的后任值 和前任反过来处理即可
    public Object predecessor(int key){
        BSTNode p = root;
        //自右而来的祖先
        BSTNode ancestorFromright =null;
        while(p!=null){
            //左边
            if(key < (int)p.key){
                ancestorFromright = p;
                p=p.left;
                //右边
            }else if(key > (int)p.key){
                p=p.right;
            }else{
                break;
            }
        }
        //没找到节点
        if(p==null){
            return null;
        }

        //节点有右子树，后继节点为右子树最小值
        if(p.right!=null){
            return min(p.right);
        }
        //节点没有右子树 那么就找最近的祖先自右而来
        return ancestorFromright !=null?ancestorFromright.value:null;
    }

    /*根据关键字删除值 不是简单的移除就行了，移除后还要满足平衡树的规则，所以删除后要进行托孤
    * 删除的节点没有左孩子，将右孩子托孤给parent
    * 删除的节点没有右孩子，将左孩子托孤给parent
    * */
    public Object delete(int key){
        BSTNode p = root;
        //待删除节点的父节点
        BSTNode parent = null;

        while(p!=null){
            //左边
            if(key < (int)p.key){
                parent = p;
                p=p.left;
                //右边
            }else if(key > (int)p.key){
                parent = p;
                p=p.right;
            }else{
                break;
            }
        }

        //没找到节点，返回null
        if(p==null){
            return null;
        }

        /*  这个判断涵盖了节点没有左右孩子的情况*/
        //找到了 开始删除 删除的节点没有左孩子，将右孩子托孤给parent
        if(p.left ==null){
            //调用托孤方法 没有左孩子那么就要把节点右孩子往上定
            shift(parent,p,p.right);

         //删除的节点没有右孩子，将左孩子托孤给parent
        }else if(p.right ==null){
            //同理
            shift(parent,p,p.left);
        }else{
            /*待删除节点左右孩子全都有的情况*/
            //1.被删除的节点现摘到后继节点
            /*规则：
            * 在二叉搜索树（BST）中，任一节点的后继节点是最小的后续值节点。
            如果当前节点有右子树，则后继节点就是右子树中的最左侧节点。
            因为右子树中的所有节点值都大于当前节点值，而最左侧节点则是其中最小的。*/
            BSTNode s = p.right;
            BSTNode sParent  = p; //后继节点的父节点
            while(s.left!=null){
                sParent = s;
                s=s.left;
            }
            //后继节点s
            //判断待删除节点和父节点是否相邻，只有不相邻才处理后事
            if(sParent !=p){
                //2.处理后继节点后事 托孤
                shift(sParent,s,s.right); //不可能有左孩子 直接传右就行了
                s.right = p.right; //顶上去的右节点变为待删除节点的右节点
            }
            //3.后继节点取代被删除节点
            shift(parent,p,s);
            s.left = p.left; //同理
        }

        //删除成功，返回被删除节点的value值
        return p.value;
    }

    /*托孤方法
     *
     * @param parent 父节点
     * @param deleted 待删除的节点
     * @param child 待删除节点的孩子 要顶上去的节点
     */
    private void shift(BSTNode parent,BSTNode deleted,BSTNode child){

        //如果被删除节点是根节点，直接成为根节点
        if(parent== null){
            root= child;
        }
        //如果被删除节点在父节点的左边
        else if(deleted == parent.left){
            parent.left = child;
        }else{
            parent.right=child;
        }
    }


    /*范围查询------------------------------------------------*/

    //找< key的所有value
    public List<Object> less(int key){
        ArrayList<Object> result = new ArrayList<>();
        BSTNode s = this.root;
        Stack<BSTNode> stak = new Stack<>();

        //中序遍历得到的结果是倒叙
        while (s!=null || !stak.isEmpty()){
           //中序遍历;左值右
            if(s.left!=null){
                stak.push(s);
                s=s.left;
            }else{
                BSTNode pop = stak.pop();
                //处理值 当key小于的时候放入list 一旦条件不满足 直接break 因为只要有一个不满足后面的都不满足了 这是中序遍历的规律
                if((int)pop.key < key){
                    result.add(pop.key);
                }else{
                    break;
                }
                System.out.println(pop.value);
                s=pop.right;

            }
        }

        return result;

    }

    //找> key的所有value
    public List<Object> greater(int key){
        ArrayList<Object> result = new ArrayList<>();
        BSTNode s = this.root;
        Stack<BSTNode> stak = new Stack<>();

        //中序遍历得到的结果是倒叙
        while (s!=null || !stak.isEmpty()){
            //中序遍历;左值右
            if(s.left!=null){
                stak.push(s);
                s=s.left;
            }else{
                BSTNode pop = stak.pop();
                //处理值 当key小于的时候放入list 一旦条件不满足 直接break 因为只要有一个不满足后面的都不满足了 这是中序遍历的规律
                if((int)pop.key > key){
                    result.add(pop.value);
                }else{
                    break;
                }
                s=pop.right;

            }
        }

        return result;

    }

    //找两个key中间的所有value
    public List<Object> between(int key1,int key2){
        ArrayList<Object> result = new ArrayList<>();
        BSTNode s = this.root;
        Stack<BSTNode> stak = new Stack<>();

        //中序遍历得到的结果是倒叙
        while (s!=null || !stak.isEmpty()){
            //中序遍历;左值右
            if(s.left!=null){
                stak.push(s);
                s=s.left;
            }else{
                BSTNode pop = stak.pop();
                if((int)pop.key > key1 && (int)pop.key < key2){
                    result.add(pop.value);
                }else{
                    break;
                }

                s=pop.right;

            }
        }

        return result;

    }
}
