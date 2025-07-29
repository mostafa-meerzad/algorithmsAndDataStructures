package HashTable;

import java.util.HashMap;
import java.util.Map;

public class HashTable {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "John");
        map.put(2, "Joe");
        map.put(3, "Jasmin"); // putting a new value to the existing key will override that key's value
        map.put(null, "Tom"); // HashMap allows for null for the key, but only once null key
        map.put(4, null); // but you can have as many nulls for the value part of the key-value pair
        map.put(5, null);
        System.out.println(map); //=> {null=Tom, 1=John, 2=Joe, 3=Jasmin, 4=null, 5=null}

        // retrieve values from hashmap
        System.out.println(map.get(1)); //=> John  O(1)
        System.out.println(map.get(null)); //=> Tom, since null is allowed as a key, hashmap returns the value associated with

        // checking for the existing of a value and a key
        System.out.println(map.containsKey(1)); // time complexity O(1)
        System.out.println(map.containsValue("John")); // time complexity O(n)

        for(var item: map.keySet()){
            System.out.println(item); // returns the keys for each key-value pairs
            //it returned the following values
            //
            //null
            //1
            //2
            //3
            //4
            //5
        }

        for(var item: map.entrySet()){
            System.out.println(item);
            // it returned the following key-value pairs
            //
            //null=Tom
            //1=John
            //2=Joe
            //3=Jasmin
            //4=null
            //5=null
        }

    }


}
