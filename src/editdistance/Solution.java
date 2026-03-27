// LeetCode 72. Edit Distance
// using Dynamic Programming
// there are overlapping subproblems
// there will be a TLS when submitting to LeeCode
package editdistance;

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // i and j ponit the last index
        return dp(word1, m - 1, word2, n - 1);
    }

    // definition: return the minimum edit distance of s1[0..i] and s2[0..j]
    private int dp(String s1, int i, String s2, int j) {
        // base case
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp(s1, i - 1, s2, j - 1); // do nothing
        }
        return min(
            dp(s1, i, s2, j - 1) + 1, // insert
            dp(s1, i - 1, s2, j) + 1, // delete
            dp(s1, i - 1, s2, j - 1) + 1 // replace
        );
    }

    // tool method: find the smallest number in three integer number
    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
