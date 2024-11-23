package 题.链表;

public class 合并两个有序链表 {
    public static void main(String[] args) {
        Node node5 = new Node(6,null);
        Node node4 = new Node(5,node5);
        Node nodes = new Node(4,node4);

        Node node2 = new Node(2,null);
        Node node1 = new Node(1,node2);
        Node nodef = new Node(1,node1);


        Node head =new Node(-1,null);
        //这个当作head的指针，修改这个内容就是修改head，因为要断开内容
        //所以必须要这么做，如果直接操作head那么head.next的话值直接就丢失了
        Node result=head;

        //逻辑很简单，就是判断谁小然后谁就到新链表里面去
        while(nodes!=null &&nodef!=null){
            if(nodef.value < nodes.value){
                result.next = nodef;
                nodef=nodef.next;
            }else{
                result.next = nodes;
                nodes=nodes.next;
            }
            result=result.next;
        }
        if(nodef !=null){
            result.next=nodef;
        }
        if(nodes !=null){
            result.next=nodes;
        }


        while(head!=null){
            System.out.println(head.value);
            head=head.next;
        }

    }
}
