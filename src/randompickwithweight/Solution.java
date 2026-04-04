// LeetCode 528. Random Pick with Weight
package randompickwithweight;

import java.util.Random;

public class Solution {
    // the array of prefix sum
    private int[] preSum;
    private Random rand = new Random();


    public Solution(int[] w) {
        int n = w.length;

        // construct the array of prefix sum, offset by one to reserve preSum[0]
        preSum = new int[n + 1];
        preSum[0] = 0;
        // preSum[i] = sum(w[0..i-1])
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + w[i - 1];
        }
    }

    public int pickIndex() {
        int n = preSum.length;
        // randomly select a number in close interval [1, preSum[n - 1]]
        int target = rand.nextInt(preSum[n - 1]) + 1;
        // get the index of target in preSum
        return left_bound(preSum, target) - 1;
    }

    private int left_bound(int[] nums, int target) {
        // base case
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length;

        // binary search
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        return left;
    }
}
