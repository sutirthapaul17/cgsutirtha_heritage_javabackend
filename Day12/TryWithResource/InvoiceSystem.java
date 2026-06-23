package TryWithResource;

import java.io.*;
import java.time.LocalDate;

public class InvoiceSystem {
    // Generate invoice file for an order
    public static void generateInvoice(int orderId, String customer,
                                       String[] items, double[] prices) {
        String filename = "invoice_" + orderId + ".txt";
        try (
                FileWriter fw = new FileWriter(filename);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            bw.write("==========================================");
            bw.newLine();
            bw.write("          TECHMART INVOICE               ");
            bw.newLine();
            bw.write("==========================================");
            bw.newLine();
            bw.write("Order ID  : #" + orderId);
            bw.newLine();
            bw.write("Customer  : " + customer);
            bw.newLine();
            bw.write("Date      : " + LocalDate.now());
            bw.newLine();

            bw.write("------------------------------------------");
            bw.newLine();
            double total = 0;
            for (int i = 0; i < items.length; i++) {
                bw.write(String.format("%-25s  Rs.%8.2f%n", items[i], prices[i]));
                total += prices[i];
            }
            bw.write("------------------------------------------");
            bw.newLine();
            bw.write(String.format("TOTAL                       Rs.%8.2f%n", total));
            bw.write("==========================================");
            bw.newLine();
            System.out.println("Invoice generated: " + filename);
        } catch (IOException e) {
            System.out.println("Invoice generation failed: " + e.getMessage());
        }
        // All streams AUTOMATICALLY closed — no resource leak possible
    }

    public static void main(String[] args) {
        generateInvoice(5042, "Deepika Nair",
                new String[]{"Laptop HP 15", "Wireless Mouse", "USB-C Hub"},
                new double[]{55000, 1200, 2500});
    }
}

