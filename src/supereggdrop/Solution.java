// LeetCode 887. Super Egg Drop
// optimize by using Memo
package supereggdrop;

import java.util.Arrays;

public class Solution {
    // memo
    private int[][] memo;

    public int superEggDrop(int k, int n) {
        // m would not exceed n (linear search)
        memo = new int[k + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -666);
        }
        return dp(k, n);
    }

    // definition: k: eggs, n: floors, dp(k, n): minimum drop times
    private int dp(int k, int n) {
        // base case
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }

        // search in memo
        if (memo[k][n] != -666) {
            return memo[k][n];
        }

        // state transition
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            // test in all floors, get the minimum drop times
            res = Math.min(res, Math.max(
                dp(k, n - i), // unbroken
                dp(k - 1, i - 1) // broken
            ) + 1);
        }

        // store the result into memo
        memo[k][n] = res;
        return res;
    }
}
