package io.dmitryerikin.leetcode.algorithms.removeelement;

import static java.util.Arrays.sort;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {3, 2, 2, 3}; // Input array
        int val = 3; // Value to remove
        int[] expectedNums = {2, 2, 0, 0}; // The expected answer with correct length.
        // It is sorted with no values equaling val.

        int k = solution.removeElement(nums, val); // Calls your implementation

        test(k, nums, expectedNums);

        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2}; // Input array
        val = 2; // Value to remove
        expectedNums = new int[]{0, 1, 4, 0, 3, 0, 0, 0}; // The expected answer with correct length.
        // It is sorted with no values equaling val.

        k = solution.removeElement(nums, val); // Calls your implementation

        test(k, nums, expectedNums);

    }

    public static void test(int k, int[] nums, int[] expectedNums) {
        System.out.println(k);
        assert k == expectedNums.length;

        sort(nums, 0, k); // Sort the first k elements of nums
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
            System.out.print(nums[i] + "");
        }
        System.out.println("");
    }

    public int removeElement(int[] nums, int val) {
        int j = nums.length - 1;
        for (int i = 0; i <= j;) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }
        return nums.length - (nums.length - j) + 1;
    }

}
