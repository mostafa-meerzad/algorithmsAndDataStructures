import java.util.Arrays;
import java.util.LinkedList;

public class LearningLinkedLists {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        list.addFirst(3);
        list.addFirst(2);

        System.out.println(list);
        list.removeFirst();
        list.removeLast();

        System.out.println(list);

        System.out.println(list.contains(10));
        System.out.println(list.indexOf(10));
        System.out.println(list.lastIndexOf(20));
        System.out.println(list.remove(2));

        System.out.println(Arrays.toString(list.toArray()));


    }
}
