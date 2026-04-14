// LeetCode 2239. Find Closest Number to Zero
// Tag: Hot100
package findclosetnumbertozero;

public class SolutionII {
    public int findClosestNumber(int[] nums) {
        int minDiff = Integer.MAX_VALUE;
        int result = 0;

        for (int num : nums) {
            int diff = Math.abs(num);

            // current distance is smaller than result
            if (diff < minDiff) {
                minDiff = diff;
                result = diff;
            } else if (diff == minDiff) {
                // when absolute value is same, compare the result and current value 
                result = Math.max(result, num);
            }
        }

        return result;
    }
}
