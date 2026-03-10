// LeetCode 344. Reverse String
package reversestring;

public class Solution {
    public void reverseString(char[] s) {
        // Left and right pointers move toward each other
        int left = 0;
        int right = s.length - 1;
        
        while (left < right) {
            // switch s[left] and s[right]
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
