package 题.链表;

public class 反转链表 {


    public static void main(String[] args) {
        Node node5 = new Node(5,null);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);
        Node node = new Node(0,node1);

        //原理是 从第二个节点开始获取，先将第二个节点拿出 然后断开
        //一和二的联系，让一和三链接起来，放在反转的链表revNode中
        // 然后将第二个节点的next指向revNode，达到将第二节点挪到头部
        //的效果。
        //上述操作，将存放第二节点的链表赋值给revNode进行存放
        //然后把nextNode指针向后移（这里每次循环最后要根据初始链表Node向后移）
        //可以理解为无限获取第二节点然后返回一开始的操作重复

        //用来存放反转的链表
        Node revNode = node;

        //取后一位节点，这个是用来断开链表联系的
        Node nextNode = node.next;

        while(nextNode!=null){

            //断开一节点和二节点的联系（nextNode以及在一开始或者循环最后面赋值为node.next ,也就是说这行代码就是node.next =node.next.next）
            node.next = nextNode.next;

            //让nextNode的下一个节点直接指向revNode  把二节点挪到一节点前面
            //意思就是把nextNode挪到revNode的最前面
            //这里不能用nextNode.next=node是因为，node在断开节点后，原有的内容就没了，如果这个时候直接把nextNode挪到node前面的话，会丢失值，
            //所以要用revnode来存放，虽然revnode指向的也是node，而且node值改了revnode也会改
            //但是在下一步revnode会重新赋值等于nextNode，所以不用担心revnode会丢失值
            nextNode.next = revNode;

            //用revNode去装挪好的代码，因为nextNode是当作指针移动，不能存结果，需要用额外存放反转的链表来存
            //而且这样确保，每次断开节点的值都会正确的存放到新链表中
            revNode=nextNode;

            nextNode = node.next;

        }


        while(revNode!=null){
            System.out.println(revNode.value);
            revNode = revNode.next;
        }
    }


}
