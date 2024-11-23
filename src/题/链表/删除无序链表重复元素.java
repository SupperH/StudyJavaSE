package 题.链表;

import java.util.HashSet;

public class 删除无序链表重复元素 {
    public static void main(String[] args) {
        Node node5 = new Node(4, null);
        Node node4 = new Node(3, node5);
        Node node3 = new Node(2, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        Node node = new Node(1, node1);

        // 使用哈希表来记录已经出现过的值
        HashSet<Integer> seen = new HashSet<>();
        Node prev = node;
        Node current = node;

        //第一次循环只会做current后移操作
        while (current != null) {
            // 如果当前值已经在哈希表中，跳过当前节点
            if (seen.contains(current.value)) {
                //断开两个节点的联系，虽然这里操作的是prev和current，但是因为两个指向的是node，所以这么做实际上就是操作了node
                //比如循环到第3次，seen中有了2，1 然后prev是1，2，2，3，3 node是2，2，3，3，这时候断开prev和next的联系就是1，2，3，3
                //再次循环 seen中还有2，1，prev是1，2，3，3 node是2，3，3断开联系就是1，3，3
                //最后以此类推，断开联系完后就是1，3 然后由于操作的是node，是从第二个值开始进行操作的，因为第一次进来单纯做了current后移操作，然后再进行操作 node第一个值肯定是一直存在
                //所以回到node 结果就是2，1，3
                prev.next = current.next;
            } else {
                // 否则将当前值加入哈希表，并更新前驱节点
                seen.add(current.value);
                //prev要等于没有移动后的current，当作前一个节点来使用
                //其实也相当于后移操作，只是每次都比current慢一拍或者多拍
                //这一步的目的是为了确保 prev 总是指向最新的、未被删除的节点
                //如果直接写 prev = prev.next，那么即使 current 是重复节点，prev 也会被移动到 current。（因为这里最初定义 prev和current都是指向node）这会导致 prev 指向一个不应该保留的重复节点。
                //通过 prev = current，我们确保 prev 只在 current 不是重复节点时才向前移动。（当current是重复节点的时候会断开联系然后将current后移，不会让prev指向current，只有
                // 当current的值是第一次出现才会挪动prev）
                prev = current;
            }
            // 无论如何，current指针都向后移动
            current = current.next;
        }

        // 输出结果
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
