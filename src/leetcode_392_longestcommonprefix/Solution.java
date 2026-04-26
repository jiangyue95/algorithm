// LeetCode 392. Longest Common Prefix
// Tags: Hot 100
package leetcode_392_longestcommonprefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Check by rows
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            // Use the first string as the standard string
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                // Check other strings 
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {

                    return strs[0].substring(0, i);
                }
            }
        }
        
        return strs[0];
    }
}
