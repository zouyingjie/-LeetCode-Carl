package com.leetcode.p15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * 1. 暴力破解，三重循环
     *
     * 2. 继续采用 2sum 的思路，确定一个数后，就是 2 sum 的解法了
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 2; i ++) {
            List<Integer> list = new ArrayList<>();
            int target = -nums[i];
            for (int j = i + 1; j <nums.length - 1; j ++) {
                if (map.containsKey(target - nums[j])) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(target - nums[j]);
                    result.add(list);
                    continue;
                }
                map.put(nums[j], j);

            }
        }
        return result;
    }
}
