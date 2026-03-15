// LeetCode 496. Next Greater Element I
package nextgreaterelementi;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // record the nex greater element of each element in nums2
        int[] greater = nextGreaterElement(nums2);
        // transfer it into a mapping element x to the next greater element of x
        HashMap<Integer, Integer> greaterMap = new HashMap<>();
        for (int i = 0; i < nums2.length - 1; i++) {
            greaterMap.put(nums2[i], greater[i]);
        }
        // nums1 is a subset of nums2, hence basing on greaterMap can get outcome
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = greaterMap.get(nums1[i]);
        }
        return res;
    }

    private int[] nextGreaterElement(int[] nums) {
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
