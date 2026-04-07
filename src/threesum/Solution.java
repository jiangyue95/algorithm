// LeetCode 15. 3Sum
package threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<List<Integer>> pairs = twoSumTarget(nums, i + 1, 0 - nums[i]);
            for (List<Integer> pair : pairs) {
                result.add(Arrays.asList(nums[i], pair.get(0), pair.get(1)));
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return result;
    }
    
    private List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        int lo = start;
        int hi = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();

        while (lo < hi) {
            int left = nums[lo];
            int right = nums[hi];
            int sum = left + right;

            if (sum < target) {
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            } else {
                result.add(Arrays.asList(left, right));
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            }
        }

        return result;
    }
}
