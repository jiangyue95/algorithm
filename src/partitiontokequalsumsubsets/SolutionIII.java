// LeetCode 698. Partition to K Equal Sum Subsets
// This solution is a optimization of SolutionII.
package partitiontokequalsumsubsets;

import java.util.HashMap;

public class SolutionIII {
    private HashMap<Integer, Boolean> memo = new HashMap<>();

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

        int used = 0; // using bitmask
        int target = sum / k;

        // backtrack to check if nums can be partitioned into k subsets each summing to target
        return backtrack(k, 0, nums, 0, used, target);
    }

    private boolean backtrack(int k, int bucket, int[] nums, int start, int used, int target) {
        // base case
        if (k == 0) {
            return true;
        }

        if (memo.containsKey(used)) {
            return memo.get(used);
        }

        if (bucket == target) {
            // current bucket is full, recursively enumerate the choice of the next bucket
            // next bucket selects number from nums[0]
            boolean res = backtrack(k - 1, 0, nums, 0, used, target);
            memo.put(used, res);
            return res;
        }

        for (int i = start; i < nums.length; i++) {
            // prunning
            if (((used >> i) & 1) == 1) { // check if the i-th bit is set
                // nums[i] is already used in other bucket
                continue;
            }

            if (nums[i] + bucket > target) {
                continue;
            }

            // make selection
            used |= 1 << i; // set i-th bit
            bucket += nums[i];

            // recursively enumerate next number
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }

            // undo selection
            used ^= 1 << i; // use XOR to clear the i-th bit
            bucket -= nums[i];
        }

        // enumerate all numbers, cannot fill current bucket
        memo.put(used, false);
        return false;
    }
}
