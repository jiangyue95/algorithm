// LeetCode 46. Permutations
package permutations;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    // store the recursive track of backtracking algorithm
    private LinkedList<Integer> track = new LinkedList<>();
    // the elements in track mark as true
    private boolean[] used;

    // main method
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }
    
    // core method of backtracking algorithm
    private void backtrack(int[] nums) {
        // base case
        if (track.size() == nums.length) {
            // collect the value on the leaf
            res.add(new LinkedList(track));
            return;
        }

        // standard backtracking algorithm template
        for (int i = 0; i < nums.length; i++) {
            // the elements in track can not be selected
            if (used[i]) {
                continue;
            }
            // select
            used[i] = true;
            track.add(nums[i]);
            // excute next level backtracking
            backtrack(nums);
            // cancel selection
            track.removeLast();
            used[i] = false;
        }
    }
}
