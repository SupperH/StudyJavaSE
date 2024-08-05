package 题;

public class 删除链表倒数元素 {
    public static void main(String[] args) {


        Node node5 = new Node(4,null);
        Node node4 = new Node(3,node5);
        Node node3 = new Node(2,node4);
        Node node2 = new Node(1,node3);
        Node node1 = new Node(6,node2);
        Node node = new Node(7,node1);

        //使用快慢指针来做
        //要找倒数的话，让快指针先走n+1步，然后quick再走，因为要删除倒数的数，同样要将倒数前一个节点的下一个节点和倒数的节点断开，
        //所以实际上是取倒数的前一个节点

        int val = 1;
        Node slow = node; //慢指针
        Node quick = node;//快指针
        //这里quick！=null和val>=0都要满足，因为是走n+1步所以要>=0
        //也就是说让快指针先走，然后slow再走
        while(quick!=null && val >=0){
            quick = quick.next;
            val--;
        }

            //val=-1说明所有步数都走完了，但是quick还有值，适用于非第一个的情况
            if(val == -1){
                //继续循环，如果quick不为空，就说明还没走到底
                while(quick!=null){
                    //这里就是让快指针慢指针一起一步步走了
                    quick = quick.next;
                    slow = slow.next;
                }
                //最后当结束循环，也就是走到底了，那么就直接断开链接就行了
                slow.next = slow.next.next;
            }else{
                //val等于0说明步数还没走完，quick就空了，也就是说倒着数，数到了第一个值，那么就要特别做操作了
                node = node.next;
            }




        while(node!=null){
            System.out.println(node.value);
            node = node.next;
        }

    }
}
