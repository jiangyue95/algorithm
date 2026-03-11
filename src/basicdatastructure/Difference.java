// Difference Array tool class
package basicdatastructure;

public class Difference {
    // difference array
    private int[] diff;

    /* Input a original array, the operation of interval wiil execute in this array */
    public Difference(int[] nums) {
        assert nums.length > 0;
        diff = new int[nums.length];
        // construct diff array basing on the original array
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /* add val on closed interval [i, j] */
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    /* return the outcome array */
    public int[] result() {
        int[] res = new int[diff.length];
        // construct outcome array basing on the diff array
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
