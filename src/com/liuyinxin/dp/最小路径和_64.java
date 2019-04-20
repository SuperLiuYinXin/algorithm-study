package com.liuyinxin.dp;

/**
 * @author: liuyinxin-896400010@qq.com
 * @date: 2019-04-20
 * @time: 17:40
 * do the best
 */
public class 最小路径和_64 {

    public int minPathSum(int[][] grid) {
        int w, h;
        h = grid.length;
        if (h <= 0) return 0;
        w = grid[0].length;
        if (w <= 0) return 0;

        int[][] dp = new int[h][w];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                if (j == 0 || i == 0) {
                    if (i == 0 && j != 0) {
                        dp[i][j] = dp[i][j- 1] + grid[i][j];
                    } else if (i != 0) {
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    }
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[h - 1][w - 1];
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,5}, {3, 2 , 1}};
        最小路径和_64 s = new 最小路径和_64();
        System.out.println(s.minPathSum(arr));

    }
}
