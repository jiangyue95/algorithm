// LeetCode 42. Trapping Rain Water
package trappingrainwater;

public class SolutionII {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int l_max = 0;
        int r_max = 0;

        int res = 0;

        while (left < right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);

            // res += min(l_max, r_max) - height[i];
            if (l_max < r_max) {
                res += l_max - height[left];
                left++;
            } else {
                res += r_max - height[right];
                right--;
            }
        }
        return res;
    }
}
