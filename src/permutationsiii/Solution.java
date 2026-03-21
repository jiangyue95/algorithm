// Thie is NOT a LeetCode problems.
// Given a array nums, and its elements is unique,
// and the permutations' element can be duplicated.
package permutationsiii;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> permutationsRepeat(int[] nums) {
        backtrack(nums);
        return res;
    }

    // the core method of backtrack
    private void backtrack(int[] nums) {
        // base case: reach the leaf node
        if (track.size() == nums.length) {
            // collect the value of leaf node
            res.add(new LinkedList<>(track));
            return;
        }

        // the standard template of backtracking algorithm
        for (int i = 0; i < nums.length; i++) {
            // make selection
            track.add(nums[i]);

            // execute next level backtracking tree
            backtrack(nums);

            // cancel selection
            track.removeLast();
        }
    }
}
