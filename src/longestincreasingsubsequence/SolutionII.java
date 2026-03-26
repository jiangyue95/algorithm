// LeetCode 300. Longest Increasing Subsequece
// using binary search
package longestincreasingsubsequence;

public class SolutionII {
    public int lengthOfLIS(int[] nums) {
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
