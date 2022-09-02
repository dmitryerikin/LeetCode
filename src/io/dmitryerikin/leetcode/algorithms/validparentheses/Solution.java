package io.dmitryerikin.leetcode.algorithms.validparentheses;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    private final static Map<Character, Character> alphabet = new HashMap<>();
    static {
        alphabet.put('}', '{');
        alphabet.put(')', '(');
        alphabet.put(']', '[');
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        boolean result = solution.isValid("()");
        assert result;
        System.out.println(result);

        result = solution.isValid("()[]{}");
        assert result;
        System.out.println(result);

        result = solution.isValid("(]");
        assert !result;
        System.out.println(result);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Character currentClosingParenthes;
        for (char c : s.toCharArray()) {
            currentClosingParenthes = alphabet.get(c);
            if (currentClosingParenthes != null && !stack.empty() && stack.peek() == currentClosingParenthes) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

}
