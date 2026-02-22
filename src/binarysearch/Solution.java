// Binary Search
package binarysearch;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 4};
        int target = 3;
        // System.out.println("basic binary search: " + binarySearch(nums, target));
        // System.out.println("left bound: " + leftBound(nums, target));
        // System.out.println("left bound 1: " + leftBound1(nums, target));
        System.out.println("rightBound1: " + rightBound(nums, target));
    }

    // Basic binary search algorithm
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1; // 注意
            } else if (nums[mid] > target) {
                right = mid - 1; // 注意
            }
        }
        return -1;
    }

    public static int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // Search interval is [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // Search Interval is [mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // Search Interval is [left mid - 1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        // check the bounds condition
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    // Colsed interval binary search find right boundary
    public static int rightBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
