// LeetCode 2239. Find Closest Number to Zero
// Tag: Hot 100
package findclosetnumbertozero;

public class Solution {
    public int findClosestNumber(int[] nums) {
        int result = nums[0];

        for (int num : nums) {
            if (Math.abs(num) < Math.abs(result)
                    || Math.abs(num) == Math.abs(result) && num > result) {
                result = num;
            }
        }
        
        return result;
    }
}
