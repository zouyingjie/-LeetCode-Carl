package com.leetcode.p01;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 1. 双循环暴力解法
     * 2. 空间换时间，使用 Map 作为临时存储
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(target- nums[i])) {
                result[0] = i;
                result[1] = map.get(target- nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        twoSum(new int[]{3, 3}, 6);
    }
}
