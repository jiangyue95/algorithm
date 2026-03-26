// LeetCode 53. Maximum Subarray
// using Dynamic Programming Algorithm
package maximumsubarray;

public class SolutionII {
    public int maxSubarray(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        // definition: dp[i] records the maximum sum of subarray ended with nums[i]
        int[] dp = new int[n];

        // base case
        // the first element has no subarray
        dp[0] = nums[0];

        // state transition equation
        // core codes
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }

        // find the maximum subarray
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
