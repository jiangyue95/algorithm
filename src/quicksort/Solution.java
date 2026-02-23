// Quick Sort
package quicksort;

import java.util.Arrays;

public class Solution {

    // 整体框架，二叉树前序遍历模式
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) { // 终止条件：单个元素已排序
            int pi = partition(arr, low, high); // 分区并获取 pivot 位置
            quickSort(arr, low, pi - 1); // 递归左半部分
            quickSort(arr, pi + 1, high); // 递归右半部分
        }
    }

    // 分区函数：将小于 privot 的移到左边，大于的移到右边
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 选择最后一个作为 pivot
        int i = low - 1; // 小于 pivot 的最后一个索引

        for (int j = low; j < high; j++) { // j 遍历 low 到 high - 1
            if (arr[j] < pivot) { // 发现小于 pivot 区域的右边界
                i++; // 扩展小于区域
                swap(arr, i, j); // 将小元素换到右边
            }
        }
        swap(arr, i + 1, high); // 将 pivot 放到正确的位置
        return i + 1; // 返回 pivot 最终位置
    }

    // 交换函数
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println("Quick Sort");
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("排序前: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后: " + Arrays.toString(arr));
    }
}
