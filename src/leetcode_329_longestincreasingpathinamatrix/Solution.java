// LeetCode 329. Longest Increasing Path in a Matrix
// Tags: Hot 100, DP(Dynamic Programming), DFS
package leetcode_329_longestincreasingpathinamatrix;

public class Solution {

    // Four directions
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        // Base case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, dp));
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int m = matrix.length;
        int n = matrix[0].length;

        dp[i][j] = 1;

        for (int[] dir : DIRS) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[ni][nj] > matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j], 1 + dfs(matrix, ni, nj, dp));
            }
        }

        return dp[i][j];
    }
}
