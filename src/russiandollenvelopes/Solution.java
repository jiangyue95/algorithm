// LeetCode 354. Russian Doll Envelopes
package russiandollenvelopes;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // order the array in ascending order by width
        // if the width is same, order the array by height in descending order
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });

        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }

        return lengthOfLIS(height);
    }

    private  int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        // initialize the cound of pile as 0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            int poker = nums[i];

            int left = 0;
            int right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }
        return piles;
    }
}
