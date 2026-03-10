// LeetCode 5. Longest Palindromic Substring
package longestpalindromicsubstring;

public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // the palindrome which center is s[i]
            String s1 = palindrome(s, i, i);
            // the palindrome which center is s[i] and s[i + 1]
            String s2 = palindrome(s, i, i + 1);

            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    // Search the longest palindrome which center is s[left] and s[right] in s
	private String palindrome(String s, int left, int right) {
		// Prevent index out of bounds
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			// two pointers expand in two directions
			left--;
			right++;
		}
		// Return the longest palindrome which center is s[left] and s[right] in s
		return s.substring(left + 1, right);
	}
}
