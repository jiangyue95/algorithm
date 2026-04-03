// LeetCode 870. Advantage Shuffle
// using PriorityQueue and double pointer
// time complexity: O(N * logN)
package advantageshuffle;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // sort the nums2 in descending order
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(
                (int[] pair1, int[] pair2) -> {
                    return pair2[1] - pair1[1];
            }
        );

        for (int i = 0; i < n; i++) {
            maxpq.offer(new int[]{i, nums2[i]});
        }

        // sort the nums1 in ascending order
        Arrays.sort(nums1);

        // nums[left] is the minimum value, nums1[right] is the maximum value
        int left = 0;
        int right = n - 1;

        // result
        int[] res = new int[n];

        while (!maxpq.isEmpty()) {
            int[] pair = maxpq.poll();
            // maxval is the maximum value of nums2, and i is its index
            int i = pair[0];
            int maxval = pair[1];

            if (maxval < nums1[right]) {
                // if nums1[right] is bigger than maxval, use current value
                res[i] = nums1[right];
                right--;
            } else {
                // if nums1[right] is smaller than maxval, use the minimum value in nums1
                res[i] = nums1[left];
                left++;
            }
        }

        return res;
    }
}
