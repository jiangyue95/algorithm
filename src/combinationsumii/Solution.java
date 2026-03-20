// LeetCode 40 Combination Sum II
package combinationsumii;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    // recored the path of backtracking
    private LinkedList<Integer> track = new LinkedList<>();

    // record the sum of elements in track
    private int trackSum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // base case
        if (candidates.length == 0) {
            return res;
        }

        // order firstly, make the same value together
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] nums, int start, int target) {
        // base case: reach the target, find the combination
        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }

        // base case, exceed the target
        if (trackSum > target) {
            return;
        }

        // standard backtracking template
        for (int i = start; i < nums.length; i++) {
            // pruning branches, the branches with same value
            // only traverse the first one
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // make selection
            track.add(nums[i]);
            trackSum += nums[i];
            // recursively traverse next level backtracking tree
            backtrack(nums, i + 1, target);
            // cancel selection
            track.removeLast();
            trackSum -= nums[i];
        }
    }
}
