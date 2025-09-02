package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    public char findFirstNonRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        var chars = str.toCharArray();
        for (var ch : chars) {
//            if (map.containsKey(ch)){
//                var count = map.get(ch);
//                map.put(ch, count + 1);
//            }
//            else{
//                map.put(ch, 1);
//            }
// ---------------- the if/else statement above can be written as following ------------------
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);

        }
        for (var item : chars) {
            if (map.get(item) == 1) {
                return item;
            }
        }

        return Character.MIN_VALUE; //

    }
    //        find the first repeated character in a string

    public Character findFirstRepeatedChar(String str) {
        Set<Character> seen = new HashSet<>();

        for (var ch : str.toCharArray()){
            if (seen.contains(ch)){
                return ch;
            }
            seen.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
