// LeetCode 78. Subsets
package subsets;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    // store the recurse track of backtracking algorithm
    private LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    // the core method of backtracking algorithm
    // traverse the subsets backtracking tree
    private void backtrack(int[] nums, int start) {
        // preorder position, each node's value is a subset
        res.add(new LinkedList<>(track));

        // standard backtracking algorithm template
        for (int i = start; i < nums.length; i++) {
            // select
            track.addLast(nums[i]);
            // control the traverse of tree by start
            // to prevent the generate of duplicate subsets
            backtrack(nums, i + 1);
            // cancel selection
            track.removeLast();
        }
    }
}
