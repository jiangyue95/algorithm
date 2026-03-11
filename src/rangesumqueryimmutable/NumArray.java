// LeetCode 303. Range Sum Query - Immutable
package rangesumqueryimmutable;

class NumArray {
    // The array of prefix sum
    private int[] preSum;

    // Input an array, construct the prefix sum
    public NumArray(int[] nums) {
        // preSum[0] = 0, better for calculate
        preSum = new int[nums.length + 1];
        // int arrary's default value is 0
        // preSum[0] = 0;
        // 计算 nums 的累加和
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    /* query the prefix sum of  closed interval [left, right]  */
    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}
