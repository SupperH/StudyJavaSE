package 题.链表;

public class 删除有序链表重复元素不保留元素 {
    public static void main(String[] args) {
        Node node5 = new Node(3,null);
        Node node4 = new Node(3,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);
        Node node = new Node(1,node1);

        //哨兵节点
        Node dummy = new Node(0, node);

        //复制一份节点然后操作
        Node cur = dummy;

        //这里只用一个节点解决问题，所以要判断下一个和下下个是否相等
        //原理是判断前后内容是否相等，如果相等从当前内容开始循环判断，把每个相等的值都挪走，因为这里第一个节点是哨兵，所以每次只需要操作next即可
        while (cur.next != null && cur.next.next != null) {

            //判断下一个和下下个是否相等
           if(cur.next.value == cur.next.next.value){
               //如果相等，首先把相等的内容存入临时变量
               int temp = cur.next.value;
               //再一次循环cur，条件是下一个值等于相等的内容，因为是有序的链表，所以如果不相等结束循环即可，不需要在循环里写if
               while(cur.next!=null && cur.next.value == temp){
                   //相等就断开让指向下下个内容
                   cur.next = cur.next.next;
               }
           }else{
               //如果内容不相等把cur往后移即可
               cur = cur.next;
           }
        }




        while(dummy!=null){
            System.out.print(dummy.value+" ");
            dummy = dummy.next;
        }
        System.out.println();
    }

}
