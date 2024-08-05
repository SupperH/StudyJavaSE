package SinglyLinkedList;

public class test {
    public static void main(String[] args) {
        SinglyLinkedList lk = new SinglyLinkedList();
        lk.add(1);

        lk.insert(1,2);
        lk.insert(2,3);


        lk.loop();

        lk.remove(2);
        lk.loop();
    }
}
