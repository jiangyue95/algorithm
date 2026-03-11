// LeetCode 304. Range Sum Query 2D - Immutable
package rangesumquery2dimmutable;

public class NumMatrix {
    // define: preSum[i][j] records the sum of  sub matrix [0, 0, i-1, j-1] in matrix
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Construct the matrix of prefix sum
        preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // calculate each matrix sum of [0, 0, i, j]
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1]
                        - preSum[i - 1][j - 1];
            }
        }
    }

    // calculate the sum of sub matrix [x1, y1, x2, y2]
    public int sumRegion(int x1, int y1, int x2, int y2) {
        return preSum[x2 + 1][y2 + 1] - preSum[x1][y2 + 1] - preSum[x2 + 1][y1] + preSum[x1][y1];
    }
}
