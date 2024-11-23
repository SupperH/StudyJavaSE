package 题.链表;

public class 快慢指针查找链表中间节点 {
    public static void main(String[] args) {
        Node node6 = new Node(6,null);

        Node node5 = new Node(5,node6);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node = new Node(1,node2);

        //快慢指针：
        //慢指针一次走一步，快指针一次走两步，最后当快指针下一个节点是null，
        //那么此时慢指针所在的位置就是中间节点，如果双数取后面那个

        Node s = node;
        Node q = node;

        while(q!=null && q.next!=null){
            q=q.next.next;
            s=s.next;
        }
        System.out.println(s.value);
    }
}
