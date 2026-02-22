import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // 外层循环表示总共要走多少趟
        for(int i = 0; i < n - 1; i++) {
            // 内层循环比较相邻元素
            for(int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.print("The original Arr:");
        System.out.println(Arrays.toString(arr));

        bubbleSort(arr);

        System.out.print("The sorted Arr:");
        System.out.println(Arrays.toString(arr));
    }
}