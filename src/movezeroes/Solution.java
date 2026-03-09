// LeetCode 283. Move Zeroes
package movezeroes;

public class Solution {
    public void moveZeroes(int[] nums) {
        // Remove the zeroes in nums
        // Return the length of nums without zeroes
        int p = removeElement(nums, 0);
        // assign the value of nums[p..] to 0
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }

    private int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        
        while (fast < nums.length) {
            if (nums[fast] != val) {
                // There is a difference comparing the remove duplicates.
                // Assign first, then advance the slow pointer
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
