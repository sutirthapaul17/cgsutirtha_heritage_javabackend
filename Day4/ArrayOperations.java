
public class ArrayOperations {
    public static void main(String[] args) {
        int[] arr = {15, 42, 8, 73, 31, 56};

        // ── SUM ──
        int sum = 0;
        for (int x : arr) sum += x;
        System.out.println("Sum: " + sum);

        // ── AVERAGE ──
        System.out.printf("Average: %.2f%n", (double) sum / arr.length);

        // ── MAXIMUM ──
        int max = arr[0];
        for (int x : arr) if (x > max) max = x;
        System.out.println("Max: " + max);

        // ── MINIMUM ──
        int min = arr[0];
        for (int x : arr) if (x < min) min = x;
        System.out.println("Min: " + min);
        // ── REVERSE (in-place) ──
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;  right--;
        }
        System.out.print("Reversed: ");
        for (int x : arr) System.out.print(x + " ");
    }
}

