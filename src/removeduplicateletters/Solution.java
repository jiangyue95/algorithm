// LeetCode 316. Remove Duplicate Letters
package removeduplicateletters;

import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stk = new Stack<>();

        // matain a counter that record the num of character
        // because the input is ASCII characters, the size of 256 is enough
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }


        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            // traverse the s, minus 1 to its characters
            count[c]--;

            if (inStack[c]) {
                continue;
            }

            while (!stk.isEmpty() && stk.peek() > c) {
                // if there is not element in the top of stack, stop pop
                if (count[stk.peek()] == 0) {
                    break;
                }
                // if there is any elements, continue pop
                inStack[stk.pop()] = false;
            }
            stk.push(c);
            inStack[c] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }

        return sb.reverse().toString();

    }
}
