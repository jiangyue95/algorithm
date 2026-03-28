// LeetCode 1143. Longest Common Subsequence
// using memo to eliminate overlapping subproblems
package longestcommonsubsequence;

import java.util.Arrays;

public class Solution {
    // memo, eliminate overlapping subproblems
    private int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // the value of meomo is -1, representing uncalculated
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(text1, 0, text2, 0);
    }

    // dp method
    private int dp(String s1, int i, String s2, int j) {
        // base case
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        // If the result is already calculated, return the result in the memo
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // calculate the longest common subsequence of s1[i..] and s2[j..]
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1);
        } else {
            // s1[i] or s2[j] is not in lcs at least
            memo[i][j] = Math.max(dp(s1, i + 1, s2, j), dp(s1, i, s2, j + 1));
        }

        return memo[i][j];
    }
}
