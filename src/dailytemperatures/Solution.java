// LeetCoden 739. Daily Temperatures
package dailytemperatures;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        // store element index not element
        Stack<Integer> s = new Stack<>();
        /* monotonic stack template */
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }
            // get distance between index
            res[i] = s.isEmpty() ? 0 : (s.peek() - i);
            // add index into stack, not element
            s.push(i);
        }
        return res;
    }
}
