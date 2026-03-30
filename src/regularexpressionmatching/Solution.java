// LeetCode 10. Regular Expression Matching
package regularexpressionmatching;

import java.util.Arrays;

public class Solution {
    // store the result
    private int[][] memo;

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // initialize the memo with -1, -1 represents uncalculated
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(s, 0, p, 0);
    }

    private boolean dp(String s, int i, String p, int j) {
        int m = s.length();
        int n = p.length();

        // base case: j reaches the end of p
        if (j == n) {
            return i == m;
        }

        // base case: i reaches the end of s
        if (i == m) {
            if ((n - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        // check memo
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }

        boolean res = false;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            // case 1.1
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else { // case 1.2
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            // case 2.1
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2);
            } else {
            // case 2.2
                res = false;
            }
        }

        // store the value into memo
        memo[i][j] = res ? 1 : 0;

        return res;
    }
}
