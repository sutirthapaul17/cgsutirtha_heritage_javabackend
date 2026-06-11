public class ArrayTraversal {

    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 95, 88};

        for (int i = 0; i < scores.length; i++) {
            System.out.println("Score[" + i + "] = " + scores[i]);
        }

        for (int i = scores.length - 1; i >= 0; i--) {
            System.out.print(scores[i] + " ");
        }

    }
}
