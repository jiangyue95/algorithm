// LeetCode 27. Remove Element
package removeelement;

public class Solution {
    public int removeElement(int[] nums, int val) {
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
