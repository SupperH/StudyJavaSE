package 题.链表;

public class 删除有序链表重复元素 {
    public static void main(String[] args) {
        Node node5 = new Node(3,null);
        Node node4 = new Node(3,node5);
        Node node3 = new Node(2,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);
        Node node = new Node(1,node1);

        Node prev = node; //当前节点
        Node next = prev.next;//后一个节点

        /*注意这个写法仅仅限于有序的链表，如果链表是21232就不行了*/

        while(next!=null){
            //如果前和后值相等，那么就断开两个值的联系
            if(prev.value == next.value){
                prev.next =next.next;

                //否则就将当前节点后移
            }else {
                prev = prev.next;
            }
            //不管怎么样next节点都要后移
            next = next.next;
        }
        while(node!=null){
            System.out.print(node.value+" ");
            node = node.next;
        }
        System.out.println();
    }

}
