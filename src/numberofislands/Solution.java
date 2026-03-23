// LeetCode 200. Number of Islands
package numberofislands;

public class Solution {
    // main method, calculate the num of islands
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        // traverse grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // found an island，increment the island count
                    res++;
                    // use DFS to sink the island
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // from (i, j), change the adjacent island into sea
    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            // Out of bounds
            return;
        }

        if (grid[i][j] == '0') {
            // Already is sea
            return;
        }

        // change grid[i][j] into sea
        grid[i][j] = '0';
        // sink the island in four directions (up down left right)
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
