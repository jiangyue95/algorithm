// LeetCode 64. Minimum Path Sum
// optimized by using memo
package minimumpathsum;

import java.util.Arrays;

public class Solution {
    private int[][] memo;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // construct memo
        // initialize the memo with -1
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(grid, m - 1, n - 1);
    }

    private int dp(int[][] grid, int i, int j) {
        // base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        // avoid duplicated calculation
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // add the result into the memo
        memo[i][j] = Math.min(dp(grid, i - 1, j), dp(grid, i, j - 1)) + grid[i][j];

        return memo[i][j];
    }
}
