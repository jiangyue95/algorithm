// LeetCode 912. Sort an Array
package sortanarray;

class Solution {
    private static int[] temp;

    public static int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void sort(int[] nums, int lo, int hi) {
        if (lo == hi) {
            // single element doesn't need sort
            return;
        }
        // in order of preventing overflow
        int mid = lo + (hi - lo) / 2;
        // sort the left part of nums
        sort(nums, lo, mid);
        // sort the right part of nums
        sort(nums, mid + 1, hi);
        // merge the two ordered arrays
        merge(nums, lo, mid, hi);
    }

    private static void merge(int[] nums, int lo, int mid, int hi) {
        // copy nums[lo..hi] into temp
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }

        // use two pointers, merge two ordered arrays
        int i = lo;
        int j = mid + 1;

        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                // the left part of array has been merged
                nums[p] = temp[j++];
            } else if (j == hi + 1) {
                // the right part of array has been merged
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("LeetCode 912. Sort an Array");
        System.out.println("Using merge sort");
        int[] nums = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original nums: " + java.util.Arrays.toString(nums));
        System.out.println("After sorted: " + java.util.Arrays.toString(sortArray(nums)));
    }
}
