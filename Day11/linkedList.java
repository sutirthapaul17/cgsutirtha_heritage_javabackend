import java.util.LinkedList;

public class linkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

// ── addFirst() / addLast() ──────────────────
        list.addLast("B");    // list: [B]
        list.addLast("C");    // list: [B, C]
        list.addFirst("A");   // list: [A, B, C]
        list.addFirst("0");   // list: [0, A, B, C]
        System.out.println(list);  // [0, A, B, C]

// ── getFirst() / getLast() ──────────────────
        System.out.println(list.getFirst()); // 0
        System.out.println(list.getLast());  // C

// ── removeFirst() / removeLast() ───────────
        list.removeFirst();  // removes 0
        list.removeLast();   // removes C
        System.out.println(list);  // [A, B]

// ── peek() / poll() (Queue operations) ─────
        list.addLast("C");
        System.out.println(list.peek());  // A (view head, no remove)
        System.out.println(list.poll());  // A (view and remove head)
        System.out.println(list);         // [B, C]

// ── push() / pop() (Stack operations) ──────
        list.push("Z");      // adds to front (like stack push)
        System.out.println(list.pop());   // Z (removes from front)

        // Step-by-step node creation
        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(10);  // null ← [10] → null       head=10, tail=10
        ll.add(20);  // null ← [10] ↔ [20] → null  head=10, tail=20
        ll.add(30);  // null ← [10] ↔ [20] ↔ [30] → null  head=10, tail=30

        ll.addFirst(5);
// null ← [5] ↔ [10] ↔ [20] ↔ [30] → null  head=5, tail=30

        ll.addLast(40);
// null ← [5] ↔ [10] ↔ [20] ↔ [30] ↔ [40] → null

        

    }
}
