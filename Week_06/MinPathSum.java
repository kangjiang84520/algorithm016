/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package No64;

import java.util.Arrays;

/**
 * 功能描述
 *
 * @since 2020-10-12
 */
public class MinPathSum {
    public static void main(String[] args) {
        MinPathSum m = new MinPathSum();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(m.byDp1(grid));
        System.out.println(m.byDp2(grid));

    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0] == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        return byDp2(grid);
    }

    /**
     * mi * nj dp[j] = min{dp[j-1], dp[j]} + grid[i][j]
     *
     * @param grid
     * @return
     */
    private int byDp2(int[][] grid) {
        int more = Math.max(grid.length, grid[0].length);
        int less = Math.min(grid.length, grid[0].length);
        boolean rowMore = more == grid.length;
        int[] dp = new int[less];
        dp[0] = grid[0][0];
        for (int i = 1; i < less; i++) {
            dp[i] = dp[i - 1] + (rowMore ? grid[0][i] : grid[i][0]);
        }
        System.out.println(Arrays.toString(dp));
        for (int i = 1; i < more; i++) {
            dp[0] = dp[0] + (rowMore ? grid[i][0] : grid[0][i]);
            for (int j = 1; j < less; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + (rowMore ? grid[i][j] : grid[j][i]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[less - 1];
    }

    /**
     * dp[i][j] = min{dp[i-1][j], dp[i][j-1]} + grid[i][j]
     *
     * @param grid
     * @return
     */
    private int byDp1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
