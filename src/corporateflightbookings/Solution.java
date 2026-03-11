// LeetCode 1109. Corporate Flight Bookings
package corporateflightbookings;

import basicdatastructure.Difference;

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // Initialize nums with 0
        int[] nums = new int[n];
        // Construct difference
        Difference df = new Difference(nums);

        for (int[] booking : bookings) {
            // Transfer array index needing minus 1
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            // add val in closed interval [i..j]
            df.increment(i, j, val);
        }

        return df.result();
    }
}
