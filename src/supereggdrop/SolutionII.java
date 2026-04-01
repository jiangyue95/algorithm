// LeetCode 887. Super Egg Drop
// optimize by using binary search
package supereggdrop;

import java.util.Arrays;

public class SolutionII {
    // memo
    private int[][] memo;

    public int superEggDrop(int k, int n) {
        memo = new int[k + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -666);
        }
        return dp(k, n);
    }

    private int dp(int k, int n) {
        // base case
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }

        if (memo[k][n] != -666) {
            return memo[k][n];
        }

        // using binary search instead of linear search
        int res = Integer.MAX_VALUE;
        int lo = 1;
        int hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // the two conditions that the egg brokens at midd floor or not
            int broken = dp(k - 1, mid - 1);
            int not_brokn = dp(k, n - mid);
            if (broken > not_brokn) {
                hi = mid - 1;
                res = Math.min(res, broken + 1);
            } else {
                lo = mid + 1;
                res = Math.min(res, not_brokn + 1);
            }
        }

        memo[k][n] = res;
        return res;
    }
}
