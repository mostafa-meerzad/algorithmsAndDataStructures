package LinkedListReview;

import Array.Array;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("linked list review");
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        System.out.println(list.size());
//        list.removeLast();
        list.removeFirst();
        System.out.println(list.contains(2));;
//        list.remove();
        System.out.println(list);
        var array = list.toArray();
        System.out.println(Arrays.toString(array));
    }
}
