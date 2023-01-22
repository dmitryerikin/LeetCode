package io.dmitryerikin.leetcode.algorithms.addbinary;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String result = solution.addBinary("11", "1");
        System.out.println(result);
        assert result.equals("100");

        result = solution.addBinary("1010", "1011");
        System.out.println(result);
        assert result.equals("10101");
    }

    public String addBinary(String a, String b) {
        Deque<Boolean> aDeque = new LinkedList<>();
        a.chars().mapToObj(value -> value == '1').forEach(aDeque::push);

        Deque<Boolean> bDeque = new LinkedList<>();
        b.chars().mapToObj(value -> value == '1').forEach(bDeque::push);

        StringBuilder sb = new StringBuilder();

        boolean rem = false;

        while (!aDeque.isEmpty() || !bDeque.isEmpty() || rem) {
            boolean aVal = !aDeque.isEmpty() && aDeque.pop();
            boolean bVal = !bDeque.isEmpty() && bDeque.pop();

            sb.insert(0, aVal ^ bVal ^ rem ? '1' : '0');

            rem = (aVal && bVal) || (aVal && rem) || (bVal && rem);
        }

        return sb.toString();
    }
}
