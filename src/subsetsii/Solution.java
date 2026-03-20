// LeetCode 90. Subsets II
package subsetsii;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        // preorder position, the value of each node is a subset
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            // pruning branches, the branches with same value
            // only traverse the first one
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
    
}
