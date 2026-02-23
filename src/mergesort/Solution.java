// Merge Sort
package mergesort;

public class Solution {

    // 归并排序（Merge Sort）主函数
    public static void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return; // Baseline Condition: 基线条件
        }

        int mid = low + (high - low) / 2;
        // 排序 nums[low...mid]
        mergeSort(nums, low, mid);
        // 排序 nums[mid+1...high]
        mergeSort(nums, mid + 1, high);

        // 后序位置：合并 nums[low...mid] 和 nums[mid+1...high]
        merge(nums, low, mid, high);
    }

    // 合并函数：合并 nums[low...mid] 和 nums[mid+1..high]
    private static void merge(int[] nums, int low, int mid, int high) {
        // 创建临时数组
        int[] temp = new int[high - low + 1];
        int i = low; // 左半边指针
        int j = mid + 1; // 右半边指针
        int k = 0; // 临时数组指针

        // 比较并合并
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // 剩余元素直接复制
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }

        // 复制回原数组
        for (int p = 0; p < temp.length; p++) {
            nums[low + p] = temp[p];
        }
    }

    // 测试
    public static void main(String[] args) {
        System.out.println("Merge Sort");
        int[] nums = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("排序前: ");
        printArray(nums);

        mergeSort(nums, 0, nums.length - 1);

        System.out.println("排序后: ");
        printArray(nums);
    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
