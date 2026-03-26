// LeetCode 300. Longest Increasing Subsequence
// using Dynamic Programming and Mathmatical Induction
package longestincreasingsubsequence;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        // definition: dp[i] represents the length of LIS ended with nums[i]
        int[] dp = new int[nums.length];
        // base case: dp will be initialized as 1
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // The core of this solution
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
