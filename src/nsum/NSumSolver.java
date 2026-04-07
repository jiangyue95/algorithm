// A class contians tool methods nSumTarget
// Finds all unique n-number combinations whose sum equals target.
package nsum;

import java.util.ArrayList;
import java.util.List;

public final class NSumSolver {

    private NSumSolver() {}
    
    /**
     * Finds all unique n-number combinations whose sum equals target.
     * 
     * <p>Precondition: nums must already be sorted in non-decreasing order.
     */
    public static List<List<Integer>> nSumTarget(int[] nums, int n, int start, long target) {
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        if (n < 2 || size - start < n) {
            return result;
        }

        if (n == 2) {
            int left = start;
            int right = size - 1;

            while (left < right) {
                int leftValue = nums[left];
                int rightValue = nums[right];
                long sum = (long) leftValue + rightValue;

                if (sum < target) {
                    while (left < right && nums[left] == leftValue) {
                        left++;
                    }
                } else if (sum > target) {
                    while (left < right && nums[right] == rightValue) {
                        right--;
                    }
                } else {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(leftValue);
                    pair.add(rightValue);
                    result.add(pair);

                    while (left < right && nums[left] == leftValue) {
                        left++;
                    }
                    while (left < right && nums[right] == rightValue) {
                        right--;
                    }
                }
            }

            return result;
        }

        for (int i = start; i <= size - n; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            List<List<Integer>> subResults = nSumTarget(nums, n - 1, i + 1, target - nums[i]);

            for (List<Integer> arr : subResults) {
                List<Integer> combination = new ArrayList<>();
                combination.add(nums[i]);
                combination.addAll(arr);
                result.add(combination);
            }
        }
        
        return result;
    }
    
}
