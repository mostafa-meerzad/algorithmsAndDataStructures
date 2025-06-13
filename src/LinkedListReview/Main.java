package LinkedListReview;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
//        list.addFirst(10);
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
//        System.out.println(list.contains(20));
//        System.out.println(list.indexOf(10));
//        list.addFirst(5);
//        System.out.println(list);
//        list.removeFirst();
//        list.removeLast();
        System.out.println(list.size());
//        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.getKthFromTheEnd(0));
        ;
    }
}
