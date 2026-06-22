import java.util.*;

public class PerformanceTest {
    static final int N = 100_000;
    public static void main(String[] args) {
        List<Integer> arrayList  = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // ── Test 1: Add at beginning ──────────────
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) arrayList.add(0, i);
        long alTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < N; i++) ((LinkedList<Integer>)linkedList).addFirst(i);
        long llTime = System.nanoTime() - start;

        System.out.println("Add at beginning (" + N + " ops):");
        System.out.println("  ArrayList:  " + alTime/1_000_000 + " ms  (slow: shifts)");
        System.out.println("  LinkedList: " + llTime/1_000_000 + " ms  (fast: head ptr)");

        // ── Test 2: Random access by index ────────
        List<Integer> al2 = new ArrayList<>(arrayList);
        List<Integer> ll2 = new LinkedList<>(linkedList);

        start = System.nanoTime();
        for (int i = 0; i < N; i++) al2.get(i);
        long alGet = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < N; i++) ll2.get(i);
        long llGet = System.nanoTime() - start;

        System.out.println("Random access (" + N + " ops):");
        System.out.println("  ArrayList:  " + alGet/1_000_000 + " ms  (fast: O(1))");
        System.out.println("  LinkedList: " + llGet/1_000_000 + " ms  (slow: O(n))");
    }
}
