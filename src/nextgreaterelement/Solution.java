// This is NOT a LeetCode problem.
// But this probleam can practice your monotonic stack skills in simple way.

/**
 * Given n integer array nums. Return an integer array of the same length where each element is the
 * first greater element to the right of nums[i]. If no such element exists, store -1 at that
 * position. 
 */
package nextgreaterelement;

import java.util.Stack;

public class Solution {
    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        // result array to store the answer
        int[] res = new int[n];
        // stack to maintain a monotonically decreasing sequence
        Stack<Integer> s = new Stack<>();
        
        // traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // pop elements that are less than or equal to nums[i]
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                // these elements cannot be the next greater element for nums[i]
                s.pop();
            }
            // the next great element to the right of nums[i]
            res[i] = s.isEmpty() ? -1 : s.peek();
            // push current element onto the stack
            s.push(nums[i]);
        }
        return res;
    }
}
