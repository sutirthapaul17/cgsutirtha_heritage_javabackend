package Synchronization;

public class DeadlockDemo {
    static final Object PRINTER = new Object(); // Resource 1
    static final Object SCANNER = new Object(); // Resource 2

    public static void main(String[] args) {

        //DeadLock
//        Thread employeeA = new Thread(() -> {
//            synchronized (PRINTER) {  // A grabs PRINTER
//                System.out.println("Employee A: Holds Printer, waiting for Scanner...");
//                try { Thread.sleep(100); } catch (InterruptedException e) {}
//                synchronized (SCANNER) {  // A waits for SCANNER (held by B)
//                    System.out.println("Employee A: Using both Printer and Scanner");
//                }
//            }
//        }, "Employee-A");
//
//        Thread employeeB = new Thread(() -> {
//            synchronized (SCANNER) {  // B grabs SCANNER
//                System.out.println("Employee B: Holds Scanner, waiting for Printer...");
//                try { Thread.sleep(100); } catch (InterruptedException e) {}
//                synchronized (PRINTER) {  // B waits for PRINTER (held by A) — DEADLOCK!
//                    System.out.println("Employee B: Using both Scanner and Printer");
//                }
//            }
//        }, "Employee-B");

        // SOLUTION: Always acquire locks in the SAME ORDER in all threads
        Thread employeeA = new Thread(() -> {
            synchronized (PRINTER) {  // Always PRINTER first
                synchronized (SCANNER) {
                    System.out.println("Employee A: Done!");
                }
            }
        });

        Thread employeeB = new Thread(() -> {
            synchronized (PRINTER) {  // Always PRINTER first (same order as A)
                synchronized (SCANNER) {
                    System.out.println("Employee B: Done!");
                }
            }
        });
        employeeA.start();
        employeeB.start();
        // Program hangs here forever!
    }
}

