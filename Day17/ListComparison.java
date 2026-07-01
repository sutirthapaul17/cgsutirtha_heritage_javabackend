import java.util.ArrayList;
import java.util.LinkedList;

public class ListComparison {
    public static void main(String[] args) {
        int n = 100000;
        ArrayList<Integer> arrayList = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++)
            arrayList.add(i);
        long end = System.nanoTime();
        System.out.println("ArrayList Insert Time: "
                + (end - start) + " ns");
        start = System.nanoTime();
        arrayList.remove(0);
        end = System.nanoTime();
        System.out.println("ArrayList Delete Time: "
                + (end - start) + " ns");
        LinkedList<Integer> linkedList = new LinkedList<>();
        start = System.nanoTime();
        for (int i = 0; i < n; i++)
            linkedList.add(i);
        end = System.nanoTime();
        System.out.println("LinkedList Insert Time: "
                + (end - start) + " ns");
        start = System.nanoTime();
        linkedList.removeFirst();
        end = System.nanoTime();
        System.out.println("LinkedList Delete Time: "
                + (end - start) + " ns");
    }
}