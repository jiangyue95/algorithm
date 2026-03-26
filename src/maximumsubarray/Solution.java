// LeetCode 53. Maximum Subarray
// using sliding window algorithm
package maximumsubarray;

public class Solution {
    public int maxSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        while (right < nums.length) {
            // expand the window and update the sum of elements in the window
            windowSum += nums[right];
            right++;

            // update answer
            maxSum = windowSum > maxSum ? windowSum : maxSum;

            // check if the window need to shrink
            // core code
            while (windowSum < 0) {
                // shrink the window and update the sum of elements in the window
                windowSum -= nums[left];
                left++;
            }
        }
        return maxSum;
    }
}
