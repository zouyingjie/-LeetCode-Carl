package com.leetcode.p27;

public class Solution {
    /**
     * 题目要求返回不等于目标值的数字个数，对于数组的结果没有任何限制
     *
     * 遍历数组判断数值即可，每当元素不等于目标值，则计数增加，并将计数对应的索引的值改成元素值
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[num] = nums[i];
                num++;
            }
        }
        return num;
    }

}
