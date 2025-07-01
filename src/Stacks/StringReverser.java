package Stacks;

import java.util.Stack;

public class StringReverser {
    public String reverser(String input) {
        if( input == null){
            throw new IllegalArgumentException("Input cannot be null");
        }

        // define the Stack as a "Character" s Stack "we're dealing with individual characters"
        Stack<Character> stack = new Stack<>();
//
//        for (int i = 0; i < input.length(); i++) {
//            stack.push(input.charAt(i));
//        }

//      instead of the above approach we can use `for each loop`
        for(char ch: input.toCharArray()){
            stack.push(ch);
        }
//        now this part of just using plain string can be quite inefficient, specially when the input size is really large
//        String reversed = "";
//        while (!stack.isEmpty()) {
//            reversed = reversed + stack.pop();
//        }

        // so instaed use "StringBuffer"
        StringBuffer reversed = new StringBuffer();
        while( !stack.isEmpty()){

            reversed.append(stack.pop());
        }
        // so with StringBuffer we need to convert it back to string
        return reversed.toString();
    }
}
