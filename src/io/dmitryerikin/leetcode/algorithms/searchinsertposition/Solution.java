package io.dmitryerikin.leetcode.algorithms.searchinsertposition;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 3, 5, 6};
        int result = solution.searchInsert(nums, 5);
        assert 2 == result;
        System.out.println(result);

        nums = new int[] {1, 3, 5, 6};
        result = solution.searchInsert(nums, 2);
        assert 1 == result;
        System.out.println(result);

        nums = new int[] {1, 3, 5, 6};
        result = solution.searchInsert(nums, 7);
        assert 4 == result;
        System.out.println(result);

        nums = new int[] {1, 3};
        result = solution.searchInsert(nums, 0);
        assert 0 == result;
        System.out.println(result);
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (high - low > 0) {
            mid = (high + low) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return target > nums[low] ? low + 1 : low;
    }
}
