public class LinearSearch {


    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // found at index i
            }
        }
        return -1; // not found
    }


    public static void main(String[] args) {
        int[] students = {45, 23, 67, 12, 89, 34};
        int rollNo = 67;
        int idx = linearSearch(students, rollNo);
        if (idx != -1)
            System.out.println("Found at index: " + idx);
        else
            System.out.println("Not found");
    }
}

