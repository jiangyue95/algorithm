// LeetCode 931. Minimum Falling Path Sum
// This solution is a brute force solution.
// This solution will causes TLA (Time Limit Exceeded).
package minimumfallingpathsum;

public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;

        // the finish could in any column in the last row
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

        // state transition
        return matrix[i][j]
                + min(dp(matrix, i - 1, j), dp(matrix, i - 1, j - 1), dp(matrix, i - 1, j + 1));
    }
    
    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
