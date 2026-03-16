// LeetCode 503. Next Greater Element II
package nextgreaterelementii;

import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // double the length of nums
        for (int i = 2 * n - 1; i >= 0; i--) {
            // wrap index i with modulo n, others are same like template
            while (!s.isEmpty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            res[i % n] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i % n]);
        }
        return res;
    }
}
