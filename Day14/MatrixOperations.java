import java.util.Scanner;

public class MatrixOperations {

    public static void addMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;

        int[][] result = new int[rows][cols];

        System.out.println("\nMatrix Addition:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void multiplyMatrices(int[][] A, int[][] B) {
        int r1 = A.length;
        int c1 = A[0].length;
        int c2 = B[0].length;

        int[][] result = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {

                for (int k = 0; k < c1; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        System.out.println("\nMatrix Multiplication:");

        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void transposeMatrix(int[][] A) {

        int rows = A.length;
        int cols = A[0].length;

        System.out.println("\nTranspose Matrix:");

        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void diagonalSum(int[][] A) {

        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i][i];
        }

        System.out.println("\nDiagonal Sum = " + sum);
    }

    public static boolean isIdentityMatrix(int[][] A) {

        int n = A.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j && A[i][j] != 1)
                    return false;
                if (i != j && A[i][j] != 0)
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] A = {
                {1, 2},
                {3, 4}
        };

        int[][] B = {
                {5, 6},
                {7, 8}
        };

        addMatrices(A, B);
        multiplyMatrices(A, B);
        transposeMatrix(A);
        diagonalSum(A);
        int[][] identity = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        System.out.println("\nIdentity Matrix Check:");

        if (isIdentityMatrix(identity))
            System.out.println("Matrix is Identity Matrix");
        else
            System.out.println("Matrix is NOT Identity Matrix");

        sc.close();
    }
}