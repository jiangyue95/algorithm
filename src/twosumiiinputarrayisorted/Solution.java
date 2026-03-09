// LeetCode 167. Two Sum II - Input Array is Sorted
package twosumiiinputarrayisorted;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // left and right pointer move towards each other
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                // index begains with 1
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                left--;
            }
        }
        return new int[] {-1, -1};
    }
}
