// LeetCode 583. Delete Operation for Two Strings
package deleteoperationfortwostrings;

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int lcs = longestCommonSubsequence(word1, word2);
        
        return m - lcs + n - lcs;
    }
    
    private int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // the default value is 0
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // i and j begin with 1 so the index should be minus 1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
