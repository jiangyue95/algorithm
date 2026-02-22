// LeetCode 76. Minimum Window Substring
package minimumwindowsubstring;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.err.println("LeetCode 76. Minimum Window Substring");
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("minWindow:" + minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        // 需求计数器，记录 t 中每个字符需要多少个
        HashMap<Character, Integer> need = new HashMap<>();
        // 窗口计数器，记录当前 [left, right) 窗口实际包含多少个目标字符
        HashMap<Character, Integer> window = new HashMap<>();

        //统计字符串 t 中每个字符出现的次数，构建 need 映射表
        // t.toCharArray(): 将字符串 t 转换成字符数组，便于逐个处理每个字符
        // 使用增强 for（enhanced for loop） 循环遍历 字符串 t 转换后的字符数组
        for (char c : t.toCharArray()) {
            // 对 need 中的 c 进行赋值
            // 使用 getOrDefault() 如果没找到会返回 0 
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 窗口左边界
        int left = 0;
        // 窗口右边界
        int right = 0;
        // 有效字符计数
        int valid = 0;
        // 结果起始位置
        int start = 0;
        // 最小窗口长度
        int len = s.length() + 1;


        while (right < s.length()) {
            // 获取当前 right 位置的字符
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            // 加入新字符并判断窗口是否有效
            if (need.containsKey(c)) { // 只处理目标字符，即在 need 中的字符
                // 窗口计数 + 1
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) { // 检查是否刚好满足，字符的数量要满足
                    valid++; // 有效的的字符种类 +1
                }
            }

            //  滑动窗口收缩（shrink）阶段
            while (valid == need.size()) { // 窗口有效，即有效字符种类数量等于 need 的数量
                if (right - left < len) { // 当前窗口更小时更新结果
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left); // 取出左边界字符
                left++; // 左边界右移（收缩窗口）
                if (need.containsKey(d)) { // 只处理目标字符，即在 need 中的字符
                    if (window.get(d).equals(need.get(d))) { // 移除会破坏条件
                        valid--;
                    }
                    window.put(d, window.get(d) - 1); // 窗口计数 -1
                }
            }
        }

        return len == s.length() + 1 ? "" : s.substring(start, start + len);
    }
}
