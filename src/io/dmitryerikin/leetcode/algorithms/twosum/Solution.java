package io.dmitryerikin.leetcode.algorithms.twosum;

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Make copy to find original index later
        int[] copy = Arrays.copyOf(nums, nums.length);
        // Sort original array
        Arrays.sort(nums);

        int beginIndex = 0;
        int endIndex = nums.length - 1;

        // While pointers don't reach each other
        while (beginIndex <= endIndex) {
            int current = nums[beginIndex] + nums[endIndex];
            // Check that sum of numbers on current indexes are equal target
            if (current == target) {
                // If yes, return their indexes from original array
                return new int[] {findIndexFirst(copy, nums[beginIndex]), findIndexLast(copy, nums[endIndex])};
            } else if (current > target) {
                // Else increment/decrement indexes depending on current and target value relation
                endIndex--;
            } else {
                beginIndex++;
            }
        }
        return null;
    }

    // Find index of element from the start of array
    private int findIndexFirst(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }

    // Find index of element from the end of array
    private int findIndexLast(int[] nums, int target) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 3}, 6)));
    }
}