// LeetCode 392. Is Subsequence
// Tags: Hot 100, Subquence, Two Pointers
package leetcode_392_issubsequence;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        // If s is empty, s can be any string's subsequence basing on the definition
        if (s.length() == 0) {
            return true;
        }

        int sIndex = 0;
        int tIndex = 0;

        while (tIndex < t.length()) {
            // Pointer sIndex points to the charater which waiting for check in s
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }

            // If sIndex walks through the s, all characters are matched successfully
            if (sIndex == s.length()) {
                return true;
            }

            tIndex++;
        }

        return false;
    }
}
