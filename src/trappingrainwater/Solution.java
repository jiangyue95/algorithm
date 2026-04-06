// LeetCode 42. Trapping Rain Water
// using memo to optimize
package trappingrainwater;

public class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int n = height.length;
        int res = 0;

        // memo
        int[] l_max = new int[n];
        int[] r_max = new int[n];

        // base case
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];

        // calculate l_max from left to right
        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(height[i], height[i - 1]);
        }

        // calculate r_max from right to left
        for (int i = n - 2; i >= 0; i--) {
            r_max[i] = Math.max(height[i], height[i + 1]);
        }

        // calculate result
        for (int i = 1; i < n - 1; i++) {
            res += Math.min(l_max[i], r_max[i]) - height[i];
        }

        return res;
    }
}
