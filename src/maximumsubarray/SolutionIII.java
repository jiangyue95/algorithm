// LeetCode 53. Maximum Subarray
// using Dynamic Programming Algorithm
// optimized the SolutionII by space compression
package maximumsubarray;

public class SolutionIII {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int dp_0 = nums[0];
        int dp_1 = 0;
        int res = dp_0;

        for (int i = 1; i < n; i++) {
            dp_1 = Math.max(nums[i], nums[i] + dp_0);
            dp_0 = dp_1;
            res = Math.max(res, dp_1);
        }
        return res;
    }
}
