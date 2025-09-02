package HashTable;

import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String[] args) {
//        CharFinder chFinder = new CharFinder();
//        var firstMin = chFinder.findFirstNonRepeatingChar("a green apple");
//        System.out.println(firstMin);

//        Set<Integer> numbers = new HashSet<>();
//
//        numbers.add(10);
//        numbers.add(20);
//        numbers.add(30);
//        numbers.add(20);
//
//        System.out.println("Set: " + numbers);
//        // Check if element exists
//        System.out.println("Contains 20? " + numbers.contains(20)); // true
//
//        // Remove an element
//        numbers.remove(10);
//        System.out.println("Contains 10 after remove? " + numbers.contains(10));
//
//        // size of the set
//        System.out.println("Size is " + numbers.size());

    String str = "a green apple";
    CharFinder chFinder = new CharFinder();
        System.out.println(chFinder.findFirstRepeatedChar(str));

    }
}
