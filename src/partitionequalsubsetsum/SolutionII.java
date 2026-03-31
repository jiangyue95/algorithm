// LeetCode 416. Partition Equal Subset Sum
// optimize the solution by using space compression
package partitionequalsubsetsum;

public class SolutionII {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 != 0) {
            return false;
        }

        int n = nums.length;
        sum = sum / 2;

        // dp is a one-dimension array
        boolean[] dp = new boolean[sum + 1];

        // base case
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }

        return dp[sum];
    }
}
