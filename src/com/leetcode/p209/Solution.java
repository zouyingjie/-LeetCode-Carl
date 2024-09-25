package com.leetcode.p209;

public class Solution {
    /**
     * for 循环暴力破解，时间复杂度为 O(N^2)
     *
     * 滑动窗口，从left 开始，right 不断右移求和
     * 当 sum > target 时，不断左移计算最小长度
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int minLen = Integer.MAX_VALUE;

        int sum = 0;
        int left = 0;
        for (int right = 0; right < length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left ++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0: minLen;
    }

}
