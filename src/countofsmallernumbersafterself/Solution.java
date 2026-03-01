// LeetCode 315. Count of Smaller Numbers After Self
package countofsmallernumbersafterself;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private class Pair {
        int val;
        int id;

        Pair(int val, int id) {
            // val stores the value of the element
            this.val = val;
            // id stores the index of the element
            this.id = id;
        }
    }

    // tool arrays used by merge sort
    private Pair[] temp;
    // the count of smaller numbers after self
    private int[] count;

    // main method
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        temp = new Pair[n];
        Pair[] arr = new Pair[n];
        // record the original index of element
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        // execute merge sort, store the outcome in count
        sort(arr, 0, n - 1);

        List<Integer> res = new LinkedList<>();
        for (int c : count) {
            res.add(c);
        }
        return res;
    }

    // merge sort
    private void sort(Pair[] arr, int lo, int hi) {
        if (lo == hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    // merge two ordered arrays
    private void merge(Pair[] arr, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = arr[i];
        }

        int i = lo;
        int j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == j + 1) {
                arr[p] = temp[j++];
            } else if (j == hi + 1) {
                arr[p] = temp[i++];
                // update count
                count[arr[p].id] += j - mid - 1;
            } else if (temp[i].val > temp[j].val) {
                arr[p] = temp[j++];
            } else {
                arr[p] = temp[i++];
                count[arr[p].id] += j - mid - 1;
            }
        }
    }
}
