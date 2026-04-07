// LeetCode 18. 4Sum
package foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        long t = target;

        for (int i = 0; i < n; i++) {
            List<List<Integer>> triples = threeSumTarget(nums, i + 1, t - nums[i]);
            for (List<Integer> triple : triples) {
                // construct a ordered quadruplet[nums[i], triple[0], triple[1], triple[2]]
                result.add(Arrays.asList(nums[i], triple.get(0), triple.get(1), triple.get(2)));
            }

            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return result;
    }

    private List<List<Integer>> threeSumTarget(int[] nums, int start, long target) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = start; i < n; i++) {
            List<List<Integer>> pairs = twoSumTarget(nums, i + 1, target - nums[i]);
            for (List<Integer> pair : pairs) {
                // construct a order triplet [nums[i], pair[0], pair[1]]
                result.add(Arrays.asList(nums[i], pair.get(0), pair.get(1)));
            }

            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return result;
    }

    private List<List<Integer>> twoSumTarget(int[] nums, int start, long target) {
        int lo = start;
        int hi = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();

        while (lo < hi) {
            int left = nums[lo];
            int right = nums[hi];
            long sum = (long) left + right;

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
