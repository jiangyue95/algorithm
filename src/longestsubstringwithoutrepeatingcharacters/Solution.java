// LeetCode 3. Longest Substring Without Repeating Characters
// Tags: Substring, Sliding Window
package longestsubstringwithoutrepeatingcharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Find the length of the longest substring without duplicate characters
     * @param s a string
     * @return the length of the longest substring
     */
    public int lengthOfLongestSubstring(String s) {
        // Use HashMap as the window store the times that character showes up
        Map<Character, Integer> window = new HashMap<>();

        // The boundary of the window, initialized as 0
        int left = 0;
        int right = 0;

        // Store the result
        int res = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            // Right boundary moves to right
            right++;
            // Update the data in the window
            window.put(c, window.getOrDefault(c, 0) + 1);

            // Check if the left boundary need to be shrinked
            // When the duplicate characters occur, shrink the left boundary
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                // Left boundary moves to right
                left++;
                // Update the data in the window
                window.put(d, window.get(d) - 1);
            }

            // Update the result
            res = Math.max(res, right - left);
        }

        return res;
    }
}
