import java.util.*;
import java.util.stream.*;

class Salesperson {
    String name;
    String region;
    double salary;
    double totalSales;

    Salesperson(String name, String region, double salary, double sales) {
        this.name = name; this.region = region;
        this.salary = salary; this.totalSales = sales;
    }
    public String getName()       { return name; }
    public String getRegion()     { return region; }
    public double getSalary()     { return salary; }
    public double getTotalSales() { return totalSales; }
}

public class SalesReport {
    public static void main(String[] args) {
        List<Salesperson> team = List.of(
                new Salesperson("Alice",   "North", 55000, 120000),
                new Salesperson("Bob",     "South", 38000,  90000),
                new Salesperson("Carol",   "East",  60000, 150000),
                new Salesperson("David",   "West",  45000,  75000),
                new Salesperson("Eve",     "North", 70000, 200000),
                new Salesperson("Frank",   "South", 35000,  60000)
        );

        // Report: top 3 with salary > 40000, by sales descending
        System.out.println("=== Top Sales Report ===");
        team.stream()
                .filter(s -> s.getSalary() > 40000)        // only eligible staff
                .sorted(Comparator.comparingDouble(         // sort by sales desc
                        Salesperson::getTotalSales).reversed())
                .limit(3)                                   // top 3
                .map(s -> s.getName() + " -> $" + s.getTotalSales())
                .forEach(System.out::println);
        // Eve   -> $200000.0
        // Carol -> $150000.0
        // Alice -> $120000.0

        // Average salary by region
        Map<String, Double> avgSalByRegion = team.stream()
                .collect(Collectors.groupingBy(
                        Salesperson::getRegion,
                        Collectors.averagingDouble(Salesperson::getSalary)));
        System.out.println("Avg salary by region: " + avgSalByRegion);

        // Total sales of the whole team
        double totalSales = team.stream()
                .mapToDouble(Salesperson::getTotalSales)
                .sum();
        System.out.println("Team total sales: $" + totalSales);
    }
}
