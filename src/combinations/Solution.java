// LeetCode 77. Combinations
package combinations;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    // store the recursive track of backtracking algorithm
    private LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }

    private void backtrack(int start, int n, int k) {
        // base case
        if (k == track.size()) {
            // traverse reach the kth level, collect the value of current ndoe
            res.add(new LinkedList<>(track));
            return;
        }

        // standard backtracking algorithm template
        for (int i = start; i <= n; i++) {
            // select
            track.addLast(i);
            // to prevent the generate of duplicate subsets
            backtrack(i + 1, n, k);
            // cancel selection
            track.removeLast();
        }
    }
}
