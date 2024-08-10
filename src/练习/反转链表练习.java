package 练习;


public class 反转链表练习 {
    public static void main(String[] args) {
        Node node5 = new Node(5,null);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);
        Node node = new Node(0,node1);

        //原理每次将后一个挪到最前面

        //获取下一个节点
        Node nextNode = node.next;

        //中间链表
        Node temNode = node;

        while(nextNode!=null){
          //先断开联系
            node.next = nextNode.next;

            //temp指向的是node，所以这里写temp不要写node
            nextNode.next=temNode;

            temNode = nextNode;

            nextNode=node.next;

        }
        while(temNode!=null){
            System.out.print(temNode.value+" ");
            temNode = temNode.next;
        }

    }
}
