package com.liuyinxin.dp;

/**
 *
 * 题目地址:
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * @author: liuyinxin-896400010@qq.com
 * @date: 2019-04-20
 * @time: 16:48
 * do the best
 */
public class 不同路径_II_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length <= 1 || obstacleGrid[0].length <= 1) {
            for (int[] ints : obstacleGrid) {
                for (int anInt : ints) {
                    if (anInt == 1) return 0;
                }
            }
            return 1;
        }
        int w, h;
        h = obstacleGrid.length;
        w = obstacleGrid[0].length;
        int[][] dp = new int[h][w];
        dp[0][0] = 1;
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 || j == 0) {
                        if (i == 0 && j != 0)
                            dp[i][j] = dp[i][j - 1];
                        else if (i != 0)
                            dp[i][j] = dp[i - 1][j];
                    } else
                        dp[i][j] = dp[i -1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[h-1][w - 1];
    }

}
