// LeetCode 238. Product of Array Except Self
// Tags: Hot 100
package leetcode_238_productofarrayexceptself;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Initialize the answer array
        int n = nums.length;
        int[] answer = new int[n];

        // Initialize the firest element as 1
        answer[0] = 1;

        // Calculate the left side product (from start to end)
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Initialize the right side product as 1
        int right = 1;

        // Calculate the answer from end to start
        for (int i = n - 2; i >= 0; i--) {
            // right * nums[i + 1] is the right side product
            answer[i] *= right * nums[i + 1];

            // Update the right side product
            right *= nums[i + 1];
        }

        return answer;
    }
}