import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AllIterationTypes {

    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add("Mumbai"); cities.add("Delhi"); cities.add("Chennai");
        cities.add("Kolkata"); cities.add("Bengaluru");

// ── 1. Traditional for loop ────────────────────
        System.out.println("--- Traditional for ---");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println(i + ": " + cities.get(i));
        }

// ── 2. Enhanced for-each ───────────────────────
        System.out.println("--- for-each ---");
        for (String city : cities) {
            System.out.println(city);
        }

// ── 3. Iterator (with conditional remove) ──────
        System.out.println("--- Iterator (remove cities starting with 'C') ---");
        Iterator<String> it = cities.iterator();
        while (it.hasNext()) {
            String city = it.next();
            if (city.startsWith("C")) {
                it.remove();  // removes Chennai – SAFE
            }
        }
        System.out.println(cities);  // [Mumbai, Delhi, Kolkata, Bengaluru]
        // ── 4. ListIterator (bidirectional + replace) ──
        System.out.println("--- ListIterator (replace Delhi with Pune) ---");
        ListIterator<String> lit = cities.listIterator();
        while (lit.hasNext()) {
            String city = lit.next();
            if (city.equals("Delhi")) {
                lit.set("Pune");  // replaces current element
            }
        }
        System.out.println(cities);  // [Mumbai, Pune, Kolkata, Bengaluru]

// ── 5. forEach with lambda ─────────────────────
        System.out.println("--- forEach lambda ---");
        cities.forEach(city -> System.out.println(city.toUpperCase()));

// ── 6. removeIf (functional remove) ───────────
        cities.removeIf(city -> city.length() > 6);
        System.out.println("After removeIf: " + cities);  // [Mumbai, Pune]

    }
}
