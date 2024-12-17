package LinkedList;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList();

//        myLinkedList.addLast(10);
//        myLinkedList.addLast(20);
//        myLinkedList.addLast(30);
//        myLinkedList.addFirst(10);
//        myLinkedList.addFirst(20);
//        myLinkedList.addFirst(30);
//        myLinkedList.addFirst(40);
        // [40 -> 10 -> 20 -> 30]
        //


//        myLinkedList.removeLast();
//        myLinkedList.removeLast();
//        myLinkedList.removeLast();
//        myLinkedList.removeLast();

//        myLinkedList.addFirst(50);
//        myLinkedList.removeFirst();
//        myLinkedList.removeFirst();
//        myLinkedList.removeFirst();

//        System.out.println(myLinkedList.indexOf(30));
//        System.out.println(myLinkedList.contains(20));
//        System.out.println(myLinkedList.contains(10));
        System.out.println(myLinkedList.size());
        System.out.println(Arrays.toString(myLinkedList.toArray()));
//        myLinkedList.reverse();
//        System.out.println(Arrays.toString(myLinkedList.toArray()));
        System.out.println(myLinkedList.getKThFromTheEnd(10));
    }
}
