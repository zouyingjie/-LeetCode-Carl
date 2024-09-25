package com.leetcode.p977;

public class Solution {

    /**
     * 思路：给的参数是一个升序数组，但开头可能是负数，平方后会比较大。
     *
     * 按绝对值比较，取两头是最大值，逐步向内遍历。
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int index = end;

        int[] result = new int[nums.length];
        while (index >= 0) {
            int startVal = nums[start] * nums[start];
            int endVal = nums[end] * nums[end];
            if (startVal > endVal) {
                result[index] = startVal;
                start++;
            } else {
                result[index] = endVal;
                end--;
            }
            index--;
        }
        return result;
    }
}
