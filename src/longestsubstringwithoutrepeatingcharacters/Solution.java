// LeetCode 3. Longest Substring Without Repeating Characters
package longestsubstringwithoutrepeatingcharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 用 HashMap 充当窗口，记录字符出现次数
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int res = 0; // 记录结果

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 窗口内数据的一系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 判断左侧窗口是否需要收缩
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                // 窗口内数据的一系列更新
                window.put(d, window.get(d) - 1);
            }

            // 在这里更新答案
            res = Math.max(res, right - left);
        }

        return res;
    }
}
