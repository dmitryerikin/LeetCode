package io.dmitryerikin.leetcode.algorithms.lengthoflastword;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // test lengthOfLastWord
        int l = solution.lengthOfLastWord("Hello World");
        assert l == 5;
        System.out.println(l);

        l = solution.lengthOfLastWord("   fly me   to   the moon  ");
        assert l == 4;
        System.out.println(l);

        l = solution.lengthOfLastWord("luffy is still joyboy");
        assert l == 6;
        System.out.println(l);

        // test lengthOfLastWordRegexp
        l = solution.lengthOfLastWordUsingRegexp("Hello World");
        assert l == 5;
        System.out.println(l);

        l = solution.lengthOfLastWordUsingRegexp("   fly me   to   the moon  ");
        assert l == 4;
        System.out.println(l);

        l = solution.lengthOfLastWordUsingRegexp("luffy is still joyboy");
        assert l == 6;
        System.out.println(l);

    }

    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        // the low border of the last word
        int low = -1;
        // the high border of the last word
        int high = -1;

        for (int i = chars.length - 1; i >= 0; i --) {
            // set the high border to first non escape character that means the end of the last word
            if (chars[i] != ' ' && high == -1) {
                high = i;
            }
            // set the low border to the end of the escape sequence before the last word
            if ((chars[i] == ' ') && high != -1 && low == -1) {
                low = i;
            }
        }

        return  high - low;
    }

    public int lengthOfLastWordUsingRegexp(String s) {
        String[] strings = s.split("\\s");
        return strings[strings.length - 1].length();
    }
}
