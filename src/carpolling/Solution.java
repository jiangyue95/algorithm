// LeetCode 1094. Car Polling
package carpolling;

import basicdatastructure.Difference;

public class Solution {
    public boolean carPolling(int[][] trips, int capacity) {
        // max 1001 stops
        int[] nums = new int[1001];
        // construct Difference Array
        Difference df = new Difference(nums);

        for (int[] trip : trips) {
            // num of passengers
            int val = trip[0];
            // trip[1] stop passenger onboard
            int i = trip[1];
            // trip[2] stop passenger
            // the interval that passenger is on board is [trip[1], trip[2] - 1] 
            int j = trip[2] - 1;
            // execute 
            df.increment(i, j, val);
        }

        int[] res = df.result();

        // the car should not carry passengers over capacity
        for (int i = 0; i < res.length; i++) {
            if (capacity < res[i]) {
                return false;
            }
        }
        return true;
    }
}
