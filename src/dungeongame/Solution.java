// LeetCode 174. Dungeon Game
package dungeongame;

import java.util.Arrays;

public class Solution {
    private int[][] memo;

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // initialize the memo with -1
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(dungeon, 0, 0);
    }

    private int dp(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        // base case
        if (i == m - 1 && j == n - 1) {
            return Math.max(1, 1 - grid[i][j]);
        }
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE / 2;
        }

        // search in the memo
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // state transition
        int res = Math.min(dp(grid, i, j + 1), dp(grid, i + 1, j)) - grid[i][j];

        // the knight's health is 1 at least
        memo[i][j] = Math.max(1, res);
        
        return memo[i][j];
    }
}
