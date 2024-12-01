package LinkedList;

public class Main {


    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList();

        myLinkedList.addLast(10);
        myLinkedList.addLast(20);
        myLinkedList.addLast(30);
//        myLinkedList.addFirst(40);
//        myLinkedList.addFirst(50);

        System.out.println(myLinkedList.indexOf(30));
    }
}
