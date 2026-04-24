// LeetCode 13. Roman to Integer
// Tags: Hot 100, String, HashMap
package leetcode_13_romantointeger;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    
    public int romanToInt(String s) {

        // Create the hashmap save the roman character to integer
        Map<Character, Integer> map = new HashMap<>();

        // add the mapping into hashmap
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // the last character of roman is positive
        int ans = map.get(s.charAt(s.length() - 1));

        // from left side calculate the integer
        for (int i = 0; i < s.length() - 1; i++) {
            // if current number is smaller than the next number, its value will be negative
            int sign = (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) ? -1 : 1;

            // Add the integer number to the ans
            ans += sign * map.get(s.charAt(i));
        }

        return ans;
    }
}
