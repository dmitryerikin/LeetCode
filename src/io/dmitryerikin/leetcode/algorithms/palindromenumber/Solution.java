package io.dmitryerikin.leetcode.algorithms.palindromenumber;

public class Solution {

    public boolean isPalindrome(int x) {
        // negative numbers isn't palindromes
        if (x < 0) return false;
        // one-digit numbers is palindromes
        if (x < 10) return true;

        // calculate a number that will help get decimal places from the start of x
        int beginMod = (int) Math.pow(10, (int)Math.log10(x));
        // numbers that will help get decimal places from the end of x
        int endMod = 10;
        int endDiv = 1;

        // until get middle digit(s) of number
        while (endMod <= beginMod) {
            // check pairs of decimal places equality from start and end
            if ((x / beginMod % 10) == (x % endMod / endDiv)) {
                // update numbers to get next decimal places
                beginMod /= 10;
                endMod *= 10;
                endDiv *= 10;
            } else {
                //if any pair of numbers is not equal then number is not palindrome
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        assert solution.isPalindrome(121);
        System.out.println(solution.isPalindrome(121));

        assert !solution.isPalindrome(-121);
        System.out.println(solution.isPalindrome(-121));

        assert !solution.isPalindrome(10);
        System.out.println(solution.isPalindrome(10));
    }
}
