// LeetCode 712. Minimum ASCII Delete Sum for Two Strings
// using memo to eliminate overlapping subproblems
package minimumasciideletesumfortwostrings;

import java.util.Arrays;

public class Solution {
    // memo
    private int[][] memo;

    // main method
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s1.length();

        // -1 in memo represents the result is uncalculated
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(s1, 0, s2, 0);
    }

    // definition: the minimum delete sum to make s1[i..] and s2[j..] same is dp(s1, i, s2, j)
    private int dp(String s1, int i, String s2, int j) {
        int res = 0;

        // base case
        if (i == s1.length()) {
            // when i comes to the end of s1, the rest of s2 is needed to be deleted
            for (; j < s2.length(); j++) {
                res += s2.charAt(j);
            }
            return res;
        }
        if (j == s2.length()) {
            // when j comes to the end of s2, the rest of s1 is needed to be deleted
            for (; i < s1.length(); i++) {
                res += s1.charAt(i);
            }
            return res;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            // s1[i] and s2[j] is in lcs, do not delete
            memo[i][j] = dp(s1, i + 1, s2, j + 1);
        } else {
            // s1[i] or s2[j] is in lcs at least, needed to be deleted one
            memo[i][j] = Math.min(s1.charAt(i) + dp(s1, i + 1, s2, j),
                    s2.charAt(j) + dp(s1, i, s2, j + 1));
        }

        return memo[i][j];
    }
}
