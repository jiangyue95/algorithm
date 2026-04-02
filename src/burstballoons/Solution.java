// LeetCode 312. Burst Balloons
// using Dynamic Programming
// using DP Table
package burstballoons;

public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        
        // add virtual balloons in double sides
        int[] points = new int[n + 2];
        points[0] = 1;
        points[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            points[i + 1] = nums[i];
        }

        // base case: the default value of int[][] is 0
        // do not need to initialize manually
        // core conception: the definition of dp
        int[][] dp = new int[n + 2][n + 2];

        // begain state transition
        // the direction of iteration is from bottom to top and from left to right
        for (int i = n; i >= 0; i--) { // from bottom to top
            for (int j = i + 1; j < n + 2; j++) { // from left to right
                for (int k = i + 1; k < j; k++) {
                    // make selection
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k] + dp[k][j] + points[i] * points[j] * points[k]);
                }
            }
        }

        return dp[0][n + 1];

    }
}
