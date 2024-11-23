package SinglyLinkedList;

//单向链表（不带哨兵）

/**
 * 带哨兵的话只需要把head定一个特殊值当作边界判断即可
 * 双向链表除了next，还需要有个prev指向前面（node类中） 原理都是一样
 */
public class SinglyLinkedList {
    private Node head; //头部节点


    //注意 add方法便利顺序是插入的倒叙 如果要正序用insert方法
    //添加头部
    //* 如果 this.head == null，新增节点指向 null，并作为新的 this.head
    //* 如果 this.head != null，新增节点指向原来的 this.head，并作为新的 this.head
    //  * 注意赋值操作执行顺序是从右到左
    public void add(int value){
        //比如第一次 head是空 传入1 那么就是 head = node(1,null)
        //第二次传入2 那么就是 head = node(2,node(1,null))
        this.head = new Node(value,this.head);

    }

    //遍历
    public void loop(){
        Node curr = this.head;
        while(curr !=null){
            System.out.println(curr.value);
            curr =curr.next;
        }
    }

    //根据索引获取节点
    public Node getNode(int index){
        int i = 0;
        for(Node curr = this.head;curr!=null;curr = curr.next,i++){

            if(index == i){
                return curr;
            }
        }
        return null;
    }

    //拿到节点中的值
    public int get(int index){
        Node curr = getNode(index);
        if(curr !=null){
            return curr.value;
        }else{
            throw illegalIndex(index);
        }
    }


    //插入
    public void insert(int index,int value){
        //如果输入0 直接添加到头部
        if(index == 0){
            add(value);
            return;
        }
        Node prev = getNode(index-1);
        //如果输入的数字之前没有值 则报错
        if(prev ==null){
            throw illegalIndex(index);
        }else{
            //把前一个节点指向改成插入节点 然后让插入的节点的下一个节点变为原本前一个节点的下一个节点
            prev.next = new Node(value,prev.next);
        }

    }
    //删除指定位置节点
    public void remove(int index){
        Node curr = getNode(index);
        if(curr == null){
            throw  illegalIndex(index);
        }else{
            if(index == 0){
                head = curr.next;
                return;
            }else{
                Node prev = getNode(index-1);
                prev.next = curr.next;
                return;
            }
        }
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
    }
    //节点类
    private static class Node{
        int value;
        Node next;

        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }
}


