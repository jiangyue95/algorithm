// LeetCode 1312. Minimum Insertion Steps to Make a String Palindrome
package minimuminsertionstepstomakeastringpalindrome;

import java.util.Arrays;

public class SolutionII {
    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubse(s);
    }

    private int longestPalindromeSubse(String s) {
        int n = s.length();

        // initialize the DP Table with 0
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        // base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // fill up the DP table in reverse order to ensure dependencies are computed first
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // the state transition equation
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
