// LeetCode 72. Edit Distance
// Optimize the solution with memo
package editdistance;

import java.util.Arrays;

public class SolutionII {
    private int[][] memo; // memo: store the result

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // initialize the memo a special value -1, reprenting not calcuated
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(word1, m - 1, word2, n - 1);
    }

    private int dp(String s1, int i, String s2, int j) {
        // base case
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }

        // search in memo, prevent subproblems
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // state transition, store the result into memo
        if (s1.charAt(i) == s1.charAt(j)) {
            memo[i][j] = dp(s1, i - 1, s2, j - 1); // do nothing
        } else {
            memo[i][j] = min(dp(s1, i, s2, j - 1) + 1, // insert
                    dp(s1, i - 1, s2, j) + 1, // delete
                    dp(s1, i - 1, s2, j - 1) + 1 // replace
            );
        }
        return memo[i][j];
    }

    // tool method: find the smallest number in three integer number
    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
