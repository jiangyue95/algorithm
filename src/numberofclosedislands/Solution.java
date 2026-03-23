// LeetCode 1254. Number of Closed Islands
package numberofclosedislands;

public class Solution {
    // main method, calculate the count of closed islands
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int j = 0; j < n; j++) {
            // sink the top side islands
            dfs(grid, 0, j);
            // sink the down side islands
            dfs(grid, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            // sink the left side islands
            dfs(grid, i, 0);
            // sink the right side islands
            dfs(grid, i, n - 1);
        }

        // traverse grid, left islands are closed islands
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // from (i, j), change the adjacent island into sea
    private void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            // Out of bounds
            return;
        }

        if (grid[i][j] == 1) {
            // Already is sea
            return;
        }

        // change grid[i][j] into sea
        grid[i][j] = 1;
        // sink the island in four directions (up down left right)
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
