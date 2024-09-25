package com.leetcode.p704;

/**
 * 关键点：搞清楚开闭区间
 */
public class Solution {

    /**
     * 左闭右开，right 从 nums.length 开始，二分后包含 mid
     * @param nums
     * @param target
     * @return
     */
    public int search01(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return -1;
    }

    /**
     * 左闭右闭，right 从 nums.length - 1 开始，二分后不包含 mid
     * @param nums
     * @param target
     * @return
     */
    public int search02(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
}