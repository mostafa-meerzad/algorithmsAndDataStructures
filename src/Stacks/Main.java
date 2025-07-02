package Stacks;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//
//        Stack<Integer> stack = new Stack<>();
//        stack.add(10);
//        stack.add(20);
//        stack.add(30);
//        System.out.println(stack);
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack);

//        String str = "abc";
//        StringReverser reverser = new StringReverser();
//        String result = reverser.reverser(null);
//        System.out.println(result);

//        String str = "(som{eth})ing";
//        Boolean balanced = new BalancedExpression().isBalanced(str);
//        System.out.println(balanced);

//        --------------------------
        String str = "(a<bc>{()})";
        Expression exp = new Expression();
        boolean result = exp.isBalanced(str);
        System.out.println(result);




    }
}
