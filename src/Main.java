import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Array first = new Array(4);
        first.insert(1);
        first.insert(2);
        first.insert(3);
        first.insert(4);
        first.insert(5);

        Array second = new Array(4);
        second.insert(3);
        second.insert(4);
        second.insert(5);
        second.insert(6);

//        System.out.println(Arrays.toString(first.intersect(second)));
        int[] commons = first.intersect(second);
//        System.out.println(Arrays.toString(commons));
        Array reverse = first.reverse();
        System.out.println(first.printArray());;
//        System.out.println(reverse.printArray());
        System.out.println();
        first.insertAt(9, 0);
        System.out.println(first.printArray());
    }
}