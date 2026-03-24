// LeetCode 1020. Number of Enclaves
package numberofenclaves;

public class Solution {
    public int numEnclaves(int[][] grid) {
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

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }

        if (grid[i][j] == 1) {
            return;
        }

        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
