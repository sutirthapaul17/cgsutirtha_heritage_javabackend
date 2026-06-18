
class Item {
    String name;
    Item(String name) {
        this.name = name;
    }
}
class FragileItem extends Item {
    FragileItem(String name) { super(name); }
    public void handleWithCare() {
        System.out.println("[FRAGILE] Handle with care: " + name);

    }
}
class HazardousItem extends Item {
    HazardousItem(String name) { super(name); }
    public void applyHazardProtocol() {
        System.out.println("[HAZARD] Safety protocol for: " + name);
    }
}

class RefrigeratedItem extends Item {
    int temperature;
    RefrigeratedItem(String name, int temp) {
        super(name);
        this.temperature = temp;
    }
    public void checkTemperature() {
        System.out.println("[COLD] " + name + " stored at " + temperature + "°C");
    }
}



// Warehouse processing
public class Warehouse {
    public static void processItem(Item item) {

        System.out.println("Processing: " + item.name);
        if (item instanceof FragileItem) {
            FragileItem fi = (FragileItem) item;  // downcast
            fi.handleWithCare();
        } else if (item instanceof HazardousItem) {
            HazardousItem hi = (HazardousItem) item;
            hi.applyHazardProtocol();
        } else if (item instanceof RefrigeratedItem) {
            RefrigeratedItem ri = (RefrigeratedItem) item;
            ri.checkTemperature();
        } else {
            System.out.println("Standard processing");
        }
    }

    public static void main(String[] args) {
        Item[] conveyor = {
                new FragileItem("Glass Vase"),
                new HazardousItem("Chemical Drum"),
                new RefrigeratedItem("Dairy Products", 4),
                new Item("Plastic Toy"),
        };
        for (Item item : conveyor) {
            processItem(item);
            System.out.println();
        }
    }
}
