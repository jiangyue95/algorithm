// LeetCode 410. Split Array Largest Sum
// solution is same like the LeetCode 1011
package splitarraylargestsum;

public class Solution {
    public int splitArray(int[] nums, int k) {
        return shipWithinDays(nums, k);
    }

    private  int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 1;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            // if (f(weights, mid) == days) {
            //     // search the left bound, needs to shrink right bound
            //     right = mid;
            // } else if (f(weights, mid) < days) {
            //     right = mid;
            // } else if (f(weights, mid) > days) {
            //     left = mid + 1;
            // }

            // merge the branches
            if (f(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int f(int[] weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.length;) {
            // contains cargo as much as possible
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) {
                    break;
                } else {
                    cap -= weights[i];
                }
                i++;
            }
            days++;
        }

        return days;
    }
}
