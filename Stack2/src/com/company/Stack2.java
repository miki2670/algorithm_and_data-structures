package com.company;

import java.util.Stack;

public class Stack2 {

    public static void main(String[] args) {

        //System.out.println(balPar("{()}"));
        System.out.println();

    }

    public static boolean balPar(String text) {

        Stack stack = new Stack<Character>();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '(' || text.charAt(i) == '[' || text.charAt(i) == '{') {
                stack.push(text.charAt(i));
            } else if (!stack.isEmpty() && (text.charAt(i) == ')') && stack.peek().equals('(') ||
                                           (text.charAt(i) == '}') && stack.peek().equals('{') ||
                                           (text.charAt(i) == ']') && stack.peek().equals('[')) {
                stack.pop();
            } else {
                stack.push(text.charAt(i));
            }
        }
        System.out.println(stack);
        return stack.isEmpty();
    }
}
