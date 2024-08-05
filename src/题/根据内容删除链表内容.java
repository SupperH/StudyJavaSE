package 题;

public class 根据内容删除链表内容 {
    public static void main(String[] args) {
        Node node5 = new Node(4,null);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(4,node4);
        Node node2 = new Node(4,node3);
        Node node1 = new Node(4,node2);
        Node node = new Node(4,node1);

        int val = 4;

        //有点快慢指针的意思，prev慢一步，next快一步
        //原理就是找到对应相等的位置，把前一个节点的下一个值指向下一个节点的下一个值
        Node prev =node;//用作前一个节点
        Node next =node.next;//用作后一个节点


            //仅能从第二个开始比对，如果第一个就是相等的值，那么再比较完其他的后在做一次判断即可
            while(next!=null){
                //如果第二个值等于目标值的话，把第一个值的下一个节点转为第二个值的下一个节点
                //也就是说挪走第二个值的节点，用prev存放
                if(next.value == val){
                    //挪走第二个值的节点
                    prev.next = next.next;
                    //诺走后，只要将存放下一个节点的链表往后移就行了，不用管前一个节点的链表，因为在上一步，以及把前一个节点的下一个值后移了，如果这里再后移prev的话那么prev的位置就跟next一样了
                    next = next.next;
                }else{
                    //如果不等于那么都后移即可
                    prev = prev.next;
                    next =next.next;
                }
            }

            //因为没有哨兵节点，所以没有办法处理第一个就相等的情况，那么等除了第一个都都删除后，再直接判断第一个值是否相等就行，如果相等直接后移即可
            if(node.value == val){
                node = node.next;
            }

        while(node!=null){
            System.out.println(node.value);
            node = node.next;
        }
    }


}
