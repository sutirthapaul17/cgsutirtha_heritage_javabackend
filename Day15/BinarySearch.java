public class BinarySearch {


    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int steps = 0;


        while (left <= right) {
            steps++;
            // Use left + (right-left)/2 to avoid integer overflow
            int mid = left + (right - left) / 2;


            if (arr[mid] == target) {
                System.out.println("Found in " + steps + " steps");
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1; // target is in right half
            } else {
                right = mid - 1; // target is in left half
            }
        }
        return -1; // not found
    }

    public static int binarySearchRecursive(int[] arr, int left, int right, int target) {
        if (left > right) return -1; // base case: not found
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target)
            return binarySearchRecursive(arr, mid + 1, right, target);
        else
            return binarySearchRecursive(arr, left, mid - 1, target);
    }
    // Call: binarySearchRecursive(arr, 0, arr.length-1, target)
    // Space: O(log n) due to recursion stack



    public static void main(String[] args) {
        int[] sorted = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        System.out.println(binarySearch(sorted, 23)); // index 5
        System.out.println(binarySearch(sorted, 99)); // -1
    }
}
