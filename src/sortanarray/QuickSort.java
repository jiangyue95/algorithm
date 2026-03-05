// LeetCode 912. Sort an Array
// Quick Sort
package sortanarray;

import java.util.Random;

public class QuickSort {
    public void quickSort(int[] nums) {
        // avoiding timeconsuming condition, random the nums
        shuffle(nums);
        // sort the array (in-place)
        sort(nums, 0, nums.length - 1);
    }
    
    // recursively sort method, recurse all nodes and modify
    private void sort(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return;
        }
        // slice the nums[lo..hi]
        // make nums[lo..p-1] <= nums[p] <= nums[p+1..hi]
        int p = partition(nums, lo, hi);

        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    // slice nums[lo..hi]
    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        // pay attention to the boundary
        // define the i and j as a open interval
        // and [lo, j) <= pivot; (j, hi] > pivot
        // during the following code
        // this definition of boundary need to be maintained
        int i = lo + 1;
        int j = hi;
        // while i > j, end loop
        // guarantee the coverage of interval [lo, hi]
        while (i <= j) {
            while (i < hi && nums[i] <= pivot) {
                i++;
                // when this while loop ends, nums[i] > pivot
            }
            while (j > lo && nums[j] > pivot) {
                j--;
                // when this while loop ends, nums[j] <= pivot
            }

            if (i >= j) {
                break;
            }
            // now [lo, j <= pivot && (j, hi] > pivot
            // swap nums[j] nums [i]
            swap(nums, i, j);
        }
        // finally, put the pivot in the proper postion
        // the elements on the left of pivot is smaller than pivot
        // the elements on the right of pivot is larger than pivot
        swap(nums, lo, j);
        return j;
    }

    // shuffle the array
    private void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // generate random number in [i, n - 1]
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    // swap two elements in-place
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
