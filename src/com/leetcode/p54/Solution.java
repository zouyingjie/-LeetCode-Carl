package com.leetcode.p54;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    /**
     * 每次取值，取值后移动到下一个格子
     * <p>
     * 关键是格子的移动规律，按照当前的四个方向
     * <p>
     * 右：col +1 -> (0, 1)
     * 下：row + 1 -> (1, 0)
     * 左：col - 1 (0, -1)
     * 上：row - 1 (-1, 0)
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int size = rowSize * colSize;
        int row = 0;
        int col = 0;
        int currentDirection = 0;
        while (result.size() < size) {
            result.add(matrix[row][col]);
            matrix[row][col] = 1000;

            int nextRow = row + direction[currentDirection][0];
            int nextCol = col + direction[currentDirection][1];
            // change direction
            if (nextRow < 0 || nextRow >= rowSize || nextCol < 0 || nextCol >= colSize || matrix[nextRow][nextCol] == 1000) {
                currentDirection = (currentDirection + 1) % 4;
            }

            row += direction[currentDirection][0];
            col += direction[currentDirection][1];
        }
        return result;
    }
}