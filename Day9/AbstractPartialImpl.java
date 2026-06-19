

abstract class ReportGenerator {
    // Template Method Pattern — defines the algorithm skeleton
    public final void generateReport() {   // final — cannot be overridden

        printHeader();
        printBody();     // abstract — subclass fills this
        printFooter();
    }

    private void printHeader() {
        System.out.println("======= COMPANY REPORT =======");
        System.out.println("Generated: " + java.time.LocalDate.now());
    }
    public abstract void printBody();   // Must be implemented by subclass

    private void printFooter() {
        System.out.println("====== END OF REPORT ======");
    }
}



class SalesReport extends ReportGenerator {

    @Override
    public void printBody() {
        System.out.println("Sales Q1: Rs.10,00,000");
        System.out.println("Sales Q2: Rs.12,50,000");
    }
}

class InventoryReport extends ReportGenerator {

    @Override
    public void printBody() {
        System.out.println("Total SKUs: 5420");
        System.out.println("Out of stock: 34 items");
    }
}



public class AbstractPartialImpl {
    public static void main(String[] args) {
        // Usage
        ReportGenerator r1 = new SalesReport();
        r1.generateReport();   // Header + Sales body + Footer

        ReportGenerator r2 = new InventoryReport();
        r2.generateReport();   // Header + Inventory body + Footer
    }
}
