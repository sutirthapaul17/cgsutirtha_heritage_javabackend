
interface Chargeable {
    void charge();
    int getBatteryLevel();
}
interface Connectable {
    void connectToWifi(String ssid);
    void connectToBluetooth(String device);
    boolean isConnected();
}

interface Printable {
    void print(String document);
    int getPrintQualityDPI();
}

// SmartTablet implements ALL THREE interfaces
class SmartTablet implements Chargeable, Connectable, Printable {
    private int battery = 75;
    private boolean connected = false;
    // --- Chargeable ---
    @Override
    public void charge() {
        battery = 100;
        System.out.println("Tablet charging... Battery: " + battery + "%");
    }

    @Override
    public int getBatteryLevel() { return battery; }

    // --- Connectable ---
    @Override
    public void connectToWifi(String ssid) {
        connected = true;
        System.out.println("Connected to WiFi: " + ssid);
    }

    @Override
    public void connectToBluetooth(String device) {
        System.out.println("Bluetooth paired with: " + device);
    }

    @Override
    public boolean isConnected() { return connected; }

    // --- Printable ---
    @Override
    public void print(String document) {
        System.out.println("Printing via WiFi: " + document + " at " + getPrintQualityDPI() + " DPI");
    }

    @Override
    public int getPrintQualityDPI() { return 1200; }
}


public class MultipleInterface {

    public static void main(String[] args) {
        // Usage — reference via different interface types
        SmartTablet tablet = new SmartTablet();

        Chargeable c = tablet;   // treat as Chargeable
        c.charge();

        Connectable n = tablet;  // treat as Connectable
        n.connectToWifi("Home_5G");

        Printable p = tablet;    // treat as Printable
        p.print("Invoice_2024.pdf");
    }
}
