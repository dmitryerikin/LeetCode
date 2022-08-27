package io.dmitryerikin.leetcode.algorithms.longestcommonprefix;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        assert solution.longestCommonPrefix(new String[] {"flower","flow","flight"}).equals("fl");
        System.out.println(solution.longestCommonPrefix(new String[] {"flower","flow","flight"}));

        assert solution.longestCommonPrefix(new String[] {"dog","racecar","car"}).equals("");
        System.out.println(solution.longestCommonPrefix(new String[] {"dog","racecar","car"}));

        assert solution.longestCommonPrefix(new String[] {"a"}).equals("a");
        System.out.println(solution.longestCommonPrefix(new String[] {"a"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder prefix = new StringBuilder();
        char currentChar;
        // find length of the shortest word
        int maxStringLength = Arrays.stream(strs).map(String::length).min(Integer::compareTo).get();

        // go through characters in words and compare character in each word in current index until reach maxStringLength
        for (int i = 0; i < maxStringLength; i++) {
            currentChar = strs[0].charAt(i);
            for (String str : strs) {
                if (currentChar != str.charAt(i)) {
                    return prefix.toString();
                }
            }
            prefix.append(currentChar);
        }

        return prefix.toString();
    }
}
