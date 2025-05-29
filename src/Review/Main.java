package Review;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Array numbers = new Array(3);
        numbers.print();

        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.print();
        System.out.println("-----------------");

        Array another = new Array(3);
        another.insert(10);
        another.insert(30);
        another.insert(50);
        another.print();
        System.out.println("-----------------");
        Array commons = numbers.intersect(another);
        commons.print();
        //    numbers.removeAt(0);
//    numbers.removeAt(-1);
//    numbers.removeAt(10);
//    numbers.removeAt(2);
//    numbers.print();
//        System.out.println(numbers.indexOf(10));
//        System.out.println(numbers.indexOf(40));
//        System.out.println(numbers.indexOf(50));
//        numbers.reverse();
//        numbers.print();
    }
}
