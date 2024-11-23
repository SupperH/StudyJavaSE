package 题.链表;

public class 判断回文链表 {
    public static void main(String[] args) {
        //1.找中间节点
        //2.反转后半个链表
        //3反转后的和原链表逐一比较
        Node node4 = new Node(1,null);
        Node node3 = new Node(2,node4);
        Node node2 = new Node(2,node3);
        Node node = new Node(0,node2);

        //获得中间节点的同时反转链表
        boolean flg = mid(node);

        System.out.println(flg?"是":"否");


    }

//    static Node reverse(Node node){
//        Node n1=null;
//
//        while(node!=null){
//            //node 3,2,1
//            //o2 2,1
//            //node 2,1
//            //o2 1
//            //node 1
//            //o2 null
//            Node o2=node.next;
//            //node=3,null
//            //mode=2,3,null
//            //1,2,3,null
//            node.next=n1;
//            //n1=3
//            //n1=2,3,null
//            //1,2,3,null
//            n1=node;
//            //node=2,1
//            //node=1
//            //node=null
//            node=o2;
//        }
//        return n1;
//    }
    //获取中间链表的同时反转链表然后再比较
    static boolean mid(Node node){
        Node s = node;
        Node q = node;

        //反转后的新链表
        Node n1=null;
        //额外定义一个链表存放旧链表，因为s，q会操作node，如果直接用node去反转
        //结果是不对的
        Node o1=node;
        while(q!=null && q.next!=null){
            q=q.next.next;
            s=s.next;

            //反转链表
            Node o2=o1.next;
            o1.next=n1;
            n1=o1;
            o1=o2;

        }
        //如果是奇数节点，要让慢指针再走一步，再比较，否则前后部分链表数量不相等
        if(q!=null){
            s=s.next;
        }

        //拿反转后的前半部分链表跟后半部分链表进行比较
        while(n1!=null){

            if(n1.value==s.value){
                n1=n1.next;
                s=s.next;
            }else{
                return false;
            }
        }
        return true;
    }

}
