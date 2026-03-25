// LeetCode 931. Minimum Falling Path Sum
// This solution uses memo as an optimization.
package minimumfallingpathsum;

import java.util.Arrays;

public class SolutionII {
    private int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;

        // The inital value of memo is 66666
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 66666);
        }

        // the finish could be in any columns at the last row
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp(matrix, n - 1, j));
        }
        return res;
    }

    private int dp(int[][] matrix, int i, int j) {
        // index check
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 99999;
        }

        // base case
        if (i == 0) {
            return matrix[i][j];
        }

        // search in memo, prevent duplicated calculation
        if (memo[i][j] != 66666) {
            return memo[i][j];
        }

        // state trasnition
        memo[i][j] = matrix[i][j]
                + min(dp(matrix, i - 1, j), dp(matrix, i - 1, j - 1), dp(matrix, i - 1, j + 1));
        return memo[i][j];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
