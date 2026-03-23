// LeetCode 698. Partition to K Equal Sum Subsets
// This solution spend too much time.
package partitiontokequalsumsubsets;

public class SolutionII {
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

        // target sum that each bucket must reach
        int target = sum / k;
        boolean[] used = new boolean[nums.length];

        // backtrack to check if nums can be partitioned into k subsets each summing to target
        return backtrack(k, 0, nums, 0, used, target);
    }
    
    private boolean backtrack(int k, int bucket, int[] nums, int start, boolean[] used,
            int target) {

        // base case
        if (k == 0) {
            for (boolean u : used) {
                if (!u) {
                    return false;
                }
            }
            return true;
        }

        if (bucket == target) {
            // current bucket is full, recursively enumerate the choice of the next bucket
            // next bucket selects number from nums[0]
            return backtrack(k - 1, 0, nums, 0, used, target);
        }

        // check the valid nums[i] from position start
        for (int i = start; i < nums.length; i++) {
            // prunning
            if (used[i]) {
                // nums[i] already used in other bucket
                continue;
            }
            if (nums[i] + bucket > target) {
                // current bucket cannot contain nums[i]
                continue;
            }

            // make selection, add nums[i] into current bucket
            used[i] = true;
            bucket += nums[i];

            // recursively enumerate next number
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }

            // undo selection
            used[i] = false;
            bucket -= nums[i];
        }
        // enumerate all numbers, cannot fill current bucket
        return false;
    }
}
