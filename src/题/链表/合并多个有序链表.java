package 题.链表;

public class 合并多个有序链表 {
    public static void main(String[] args) {
        Node node7 = new Node(9,null);
        Node node6 = new Node(8,node7);
        Node p3 = new Node(7,node6);

        Node node5 = new Node(6,null);
        Node node4 = new Node(5,node5);
        Node p2 = new Node(4,node4);

        Node node2 = new Node(7,null);
        Node node1 = new Node(3,node2);
        Node p1 = new Node(1,node1);


        //合并多个链表，用到的是递归加排序，有点类似于归并排序
        //本质上就是不断缩小内容然后直到只有两个链表的时候就直接单纯的比较两个
        //链表就行了，比较两个链表大小这里使用递归来做

        Node[] listNode = {p1,p2,p3};
        Node result = split(listNode,0,listNode.length-1);

        while(result!=null){
            System.out.println(result.value);
            result=result.next;
        }


    }

    //切分链表，两个int分别是左边界右边界，这里类似于归并排序

    //Divide and Conquer分而治之（分，治，合）
    //分：切分问题把一个切分成多个  split
    //治：解决问题     return listNode[i];
    //把两个结果合并在一起mergeTwoNode
    //Decrease and conquer 减而治之
    static Node split(Node[] listNode,int i,int j){
        //如果只有数组里只有一个链表，直接返回
        if(i==j){
            return listNode[i];
        }
        //找到中间值
        int mid = (i+j)>>>1;
        //拆分左边
        Node left = split(listNode,i,mid);
        //拆分右边
        Node right = split(listNode,mid+1,j);

        //排序两个链表
        return mergeTwoNode(left,right);
    }

    //这里换一种方法，用递归的思想做
    public static Node mergeTwoNode(Node p1,Node p2){
        if(p1==null){
            return p2;
        }
        if(p2==null){
            return p1;
        }

        /*递归可以理解为栈，栈的特点是先进后出
        * 那么递归的一次次调用，流程就是先调用后返回
        * 当递归触底后，返回的顺序从后到前一步步的进行返回
        *
        * https://blog.csdn.net/weiwenhou/article/details/109088914?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-1-109088914-blog-78761112.235^v43^pc_blog_bottom_relevance_base9&spm=1001.2101.3001.4242.2&utm_relevant_index=4*/



        //代码量很少 比起迭代的做法，没有定义头节点和额外操作节点的链表
        //返回更小的那个节点，并把剩余节点与另一个链表再次递归
        //返回之前，更新节点的next
        //如果p1的值小于p2，那么就让的下一个节点继续比较，一直等到最后的节点比较完，一层层进行返回
        //每一次比较的结果都应该是上一个结果的next节点

        //谁小返回谁
        if(p1.value < p2.value){
            p1.next = mergeTwoNode(p1.next,p2);
            return p1;
        }
        else{
            p2.next = mergeTwoNode(p1,p2.next);
            return p2;
        }
    }
}
