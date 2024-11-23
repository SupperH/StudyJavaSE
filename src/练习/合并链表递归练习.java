package 练习;


public class 合并链表递归练习 {

    public static void main(String[] args) {
        Node node5 = new Node(6,null);
        Node node4 = new Node(5,node5);
        Node p2 = new Node(4,node4);

        Node node2 = new Node(2,null);
        Node node1 = new Node(1,node2);
        Node p1 = new Node(1,node1);
        Node result = merge(p1,p2);
        while(result!=null){
            System.out.println(result.value);
            result=result.next;
        }

    }

    static Node merge(Node p1,Node p2){
        if(p1==null){
            return p2;
        }
        if(p2==null){
            return p1;
        }

        if(p1.value < p2.value){
            p1.next = merge(p1.next,p2);
            return p1;
        }else{
            p2.next=merge(p2.next,p1);
            return p2;
        }

    }
}
