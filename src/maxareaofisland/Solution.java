// LeetCode 695. Max Area of Island
package maxareaofisland;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // record the max area of island
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // sink the island and update the max area of island
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            // out of bounds
            return 0;
        }

        if (grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
        return dfs(grid, i + 1, j) + dfs(grid, i, j + 1) + dfs(grid, i - 1, j) + dfs(grid, i, j - 1)
                + 1;
    }   
}
