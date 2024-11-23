package 题.链表;

//回文链表，链表存在环，没有最后的节点
public class 判断回文链表_弗洛伊德龟兔赛跑 {
    public static void main(String[] args) {
        //定义一个环形链表
        Node node9 = new Node(9,null);
        Node node8 = new Node(8,node9);
        Node node7 = new Node(7,node8);
        Node node6 = new Node(6,node7);
        Node node5 = new Node(5,node6);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node = new Node(1,node2);
        node9.next=node5;

        //解题思路： 弗洛伊德龟兔赛跑（快慢指针）
        //判断链表有没有环，定义两个指针，兔和龟，龟每次走一步，兔每次走两步，
        //如果兔子最后走完了链表，说明不是回文链表，如果兔子和乌龟相遇，那么说明存在回文链表

        //进阶：判断回文链表的人口，比如上述链表，9和5形成了回文，那么入口就是5
        //当兔子和乌龟相遇后，让乌龟回到起点，这个时候兔子和乌龟每次都走一步，最后兔子和乌龟相遇的位置就是回文链表入口位置
        /*上述方法记得即可，深究就设计数学方面的问题了*/

        //判断是否是回文：
        Node s=node;
        Node q=node;
        boolean flg = false;
        while(q!=null && q.next!=null){

            s=s.next;
            q=q.next.next;
            if(s==q){
                flg=true;
                break;
            }
        }

        System.out.println(flg);
        //如果是回文，找出入口
        //重置慢节点，让乌龟回到入口
        s=node;
        if(flg){
            while(q!=null && q.next!=null){
                //这时让两个节点每次都只走一步
                s=s.next;
                q=q.next;
                if(s==q){
                    System.out.println(s.value);
                    break;
                }
            }

        }

    }
}
