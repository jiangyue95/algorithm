// LeetCode 698. Partition to K Equal Sum Subsets
package partitiontokequalsumsubsets;

import java.util.Arrays;

public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // exclude edge cases

        // the count of subsets exceeds the number of elements in nums
        if (k > nums.length) {
            return false;
        }

        // check if the total sum is evenly divisible by k
        int sum = 0;
        for (int v : nums) {
            sum += v;
        }
        if (sum % k != 0) {
            return false;
        }

        // k buckets, each tracking the current sum of its elements
        int[] bucket = new int[k];
        // target sum that each bucket must reach
        int target = sum / k;

        Integer[] numObj = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numObj[i] = nums[i];
        }

        Arrays.sort(numObj, (a, b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numObj[i];
        }

        
        // backtrack to check if nums can be partitioned into k subsets each summing to target
        return backtrack(nums, 0, bucket, target);
    }

    // try placing nums[index] into each bucket
    private boolean backtrack(int[] nums, int index, int[] bucket, int target) {
        if (index == nums.length) {
            // check if all the sum of elements in each bucket is target
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != target) {
                    return false;
                }
            }
            // nums is divided into k subsets successfully
            return true;
        }

        // try each bucket as a candidate for nums[index]
        for (int i = 0; i < bucket.length; i++) {
            if (i > 0 && bucket[i] == bucket[i - 1]) {
                continue;
            }

            // pruning, adding nums[index] would exceed the target
            if (bucket[i] + nums[index] > target) {
                continue;
            }

            // add nums[index] into bucket[i]
            bucket[i] += nums[index];

            // recurse to place the next number
            if (backtrack(nums, index + 1, bucket, target)) {
                return true;
            }

            // undo selection
            bucket[i] -= nums[index];
        }

        // nums[index] cannot be placed in any bucket
        return false;
    }
}
