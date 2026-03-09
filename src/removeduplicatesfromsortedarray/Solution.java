// LeetCode 26. Remove Duplicates from Sorted Array
package removeduplicatesfromsortedarray;

public class Solution {
    public int removeDuplicates(int[] nums) {
        // base case
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // maintain there is no duplicates in nums[0..slow]
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // the length of nums is slow + 1
        return slow + 1;
    }
}
