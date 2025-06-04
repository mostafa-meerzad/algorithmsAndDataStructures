package LinkedListReview;


public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println(list.contains(20));
        System.out.println(list.indexOf(10));
        ;
    }
}
