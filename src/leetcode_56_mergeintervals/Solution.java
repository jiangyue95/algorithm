// LeetCode 56. Merge Intervals
// Tags: Hot 100
package leetcode_56_mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // 对 intervals 进行排序 根据每组区间的第一个边界
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                // 重叠，合并
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // 不重叠，添加当前并更新
                result.add(current);
                current = intervals[i];
            }
        }

        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}
