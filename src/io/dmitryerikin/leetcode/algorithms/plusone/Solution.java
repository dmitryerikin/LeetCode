package io.dmitryerikin.leetcode.algorithms.plusone;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] result = solution.plusOne(new int[] {1, 2, 3});
        assert result[0] == 1;
        assert result[1] == 2;
        assert result[2] == 4;

        result = solution.plusOne(new int[] {4, 3, 2, 1});
        assert result[0] == 4;
        assert result[1] == 3;
        assert result[2] == 2;
        assert result[3] == 2;

        result = solution.plusOne(new int[] {9});
        assert result[0] == 1;
        assert result[1] == 0;
    }

    public int[] plusOne(int[] digits) {
        int res;
        int rem = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            res = digits[i] + rem;
            if (res > 9) {
                digits[i] = 0;
                rem = 1;
            } else {
                digits[i] = res;
                rem = 0;
            }
        }

        if (rem == 1) {
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            return newArray;
        } else {
            return digits;
        }
    }

}
