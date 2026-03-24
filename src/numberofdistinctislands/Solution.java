// LeetCode 694. Number of Distinct Islands
package numberofdistinctislands;

import java.util.HashSet;

public class Solution {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // record all island's serialized string
        HashSet<String> islands = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // sink this island, and store the serialized string
                    StringBuilder sb = new StringBuilder();
                    // the intial direction can be any directions,
                    dfs(grid, i, j, sb, 0);
                    islands.add(sb.toString());
                }
            }
        }
        return islands.size();

    }

    private void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return;
        }

        // preorder traverse position, entry (i, j)
        grid[i][j] = 0;
        sb.append(dir).append(',');

        dfs(grid, i - 1, j, sb, 1);
        dfs(grid, i + 1, j, sb, 2);
        dfs(grid, i, j - 1, sb, 3);
        dfs(grid, i, j + 1, sb, 4);

        // postorder traverse position
        sb.append(-dir).append(',');
    }
}
