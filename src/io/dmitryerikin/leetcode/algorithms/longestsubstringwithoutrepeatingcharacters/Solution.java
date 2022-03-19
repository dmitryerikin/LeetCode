package io.dmitryerikin.leetcode.algorithms.longestsubstringwithoutrepeatingcharacters;

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        char[] string = s.toCharArray();
        // HashMap to contain previous characters
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int max = 0;
        // pointer of previous duplicate character
        int border = 0;
        // current length of substring
        int current = 0;


        for (int i = 0; i < string.length; i++) {
            // check that hash map contains current character
            if (hashMap.containsKey(string[i])) {
                // if so, remove characters from border to previous duplicate character
                remove(hashMap, string, border, hashMap.get(string[i]));
                // and move border to the character that follows previous duplicate character
                border = hashMap.get(string[i]) + 1;
            } else {
                // else calculate current substring length
                current = i - border + 1;
            }
            // update max substring length
            max = Math.max(max, current);
            // put current character to the map of characters
            hashMap.put(string[i], i);
        }
        return max;
    }

    // remove characters from HashMap that contains in string from "from" to "to"
    public void remove(HashMap<Character, Integer> hashMap, char[] string, int from, int to) {
        for (int i = from; i < to; i++) {
            hashMap.remove(string[i]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        assert 3 == solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));

        assert 1 == solution.lengthOfLongestSubstring("bbbbb");
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));

        assert 3 == solution.lengthOfLongestSubstring("pwwkew");
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));

    }
}
