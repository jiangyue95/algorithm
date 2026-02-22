public class InsertionSort {

    // 插入排序方法
    public static void insertionArr(int[] arr) {
        // 遍历数组从第二个元素开始，因为第一个数组默认有序的
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;

            // 在已经排好序的部分从右向左寻找合适的位置
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j]; // 如果当前元素比current大，则将其向后移动
                j--;
            }
            // 找到合适的位置插入current
            arr[j + 1] = current;
        }
    }

    // 打印数组方法
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 主函数
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("Original Array: ");
        printArray(arr);

        // 进行插入排序
        insertionArr(arr);

        System.out.print("Sorted Array: ");
        printArray(arr);
    }
}