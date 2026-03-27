// LeetCode 53. Maximum SubArray
// using prefix array
package maximumsubarray;

public class SolutionIV {
    public int maximumSubArray(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;

        // construct the prefix sum array of nums
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int res = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // maintain minVal is the minimum value of the preSum[0..i]
            minVal = Math.min(minVal, preSum[i]);
            // the maximum sum of sub array ended by nums[i] is preSum[i + 1] - min(preSum[0..i])
            res = Math.max(res, preSum[i + 1] - minVal);
        }
        return res;
    }
}