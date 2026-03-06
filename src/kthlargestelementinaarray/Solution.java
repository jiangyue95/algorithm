// LeetCode 215. Kth Largest Element in a Array
// using bianry heap
// using quick select
package kthlargestelementinaarray;

import java.util.PriorityQueue;
import java.util.Random;

public class Solution {
    // using binary heap
    public int findKthLargest(int[] nums, int k) {
        // min bianry heap (min-heap), the top of heap is smallest element.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int e : nums) {
            // every element needs to be added into min-heap
            pq.offer(e);
            // if the quantity of the heap is more than k
            // delete the top element of min-heap
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // the remained elements in pq are k largest elements in nums
        // the element on the top of min-heap is the kth largest element
        return pq.peek();
    }

    // using quick select
    public int findKthLargest1(int[] nums, int k) {
        // shuffle the nums
        shuffle(nums);
        int lo = 0;
        int hi = nums.length - 1;
        // trsanfer target
        k = nums.length - k;
        while (lo <= hi) {
            // select a pivot in nums[lo..hi]
            int p = partition(nums, lo, hi);
            if (p < k) {
                // the kth largest element is in nums[p+1..hi]
                lo = p + 1;
            } else if (p > k) {
                // the kth largest element is in nums[lo..p-1]
                hi = p - 1;
            } else {
                // found the kth largest element
                return nums[p];
            }
        }
        return -1;
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
