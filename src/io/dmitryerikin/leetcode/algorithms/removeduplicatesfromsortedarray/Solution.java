package io.dmitryerikin.leetcode.algorithms.removeduplicatesfromsortedarray;

public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}; // Input array
        int[] expectedNums = {0, 1, 2, 3, 4, 0, 0, 0, 0, 0}; // The expected answer with correct length

        int k = solution.removeDuplicates(nums); // Calls your implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
            System.out.print(nums[i] + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        int lastNonDuplicateCharacter = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[lastNonDuplicateCharacter]) {
                nums[i] = 0;
            } else {
                lastNonDuplicateCharacter++;
                nums[lastNonDuplicateCharacter] = nums[i];
            }
        }

        return lastNonDuplicateCharacter + 1;
    }
}
