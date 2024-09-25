package com.leetcode.p59;

public class Solution {
    /**
     * 和螺旋矩阵 1 同样的思路
     *
     * 按顺时针方向改变索引，然后填充数据
     *
     * RIGHT col + 1 ——> (0, 1)
     * DOWN row + 1 ——> (1, 0)
     * LEFT col - 1 ---> (0, -1)
     * UP row - 1 --> (0 -1)
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int row = 0;
        int col = 0;
        int size = n * n;
        int num = 1;
        int currentDirection = 0;
        while (num <= size) {
            result[row][col] = num;
            num++;

            int nextRow = row + direction[currentDirection][0];
            int nextCol = col + direction[currentDirection][1];

            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || result[nextRow][nextCol] != 0) {
                currentDirection = (currentDirection + 1) % 4;
            }

            row = row + direction[currentDirection][0];
            col = col + direction[currentDirection][1];
        }
        return result;
    }
}