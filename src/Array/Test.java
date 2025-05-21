package Array;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        System.out.println(numbers.length);
        System.out.println(numbers);
        System.out.println(Arrays.toString(numbers));
        numbers[3] = 40;
    }
}
