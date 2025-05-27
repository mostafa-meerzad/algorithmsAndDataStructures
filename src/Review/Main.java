package Review;

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
//    numbers.removeAt(0);
//    numbers.removeAt(-1);
//    numbers.removeAt(10);
//    numbers.removeAt(2);
//    numbers.print();
        System.out.println(numbers.indexOf(10));
        System.out.println(numbers.indexOf(40));
        System.out.println(numbers.indexOf(50));
    }
}
