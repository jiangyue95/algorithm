// LeetCode 416. Partition Equal Subset Sum
package partitionequalsubsetsum;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // if the sum is odd, there is not possible to divide into two subset
        if (sum % 2 != 0) {
            return false;
        }

        int n = nums.length;
        sum = sum / 2;

        // DP table
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    // there is no enough space in knapsack
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // add into knapsack or not
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][sum];

    }
}
