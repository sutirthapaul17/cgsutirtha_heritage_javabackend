import java.util.Arrays;

public class LinearAndLogTime {

    // O(n) - Linear Search
    public static int findTarget(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    // O(log n) - Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    // O(n²) - Bubble Sort
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {50, 20, 40, 10, 30};

        // O(n)
        System.out.println("Linear Search Index: " + findTarget(arr, 40));

        // Sort before Binary Search
        bubbleSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));

        // O(log n)
        System.out.println("Binary Search Index: " + binarySearch(arr, 40));
    }
}