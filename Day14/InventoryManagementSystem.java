import java.util.ArrayList;

class Item {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Item(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Price: ₹" + price +
                ", Quantity: " + quantity;
    }
}

class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }
    public void addItem(Item item) {
        items.add(item);
        System.out.println(item.getName() + " added successfully.");
    }
    public void deleteItem(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                System.out.println(items.get(i).getName()
                        + " deleted successfully.");
                items.remove(i);
                return;
            }
        }
        System.out.println("Item not found.");
    }
    public void searchItem(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                System.out.println("Item Found:");
                System.out.println(item);
                return;
            }
        }
        System.out.println("Item not found.");
    }
    public void updateQuantity(int id, int quantity) {
        for (Item item : items) {
            if (item.getId() == id) {
                item.setQuantity(quantity);
                System.out.println("Quantity updated successfully.");
                return;
            }
        }
        System.out.println("Item not found.");
    }
    public double calculateInventoryValue() {
        double total = 0;

        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }

        return total;
    }
    public void displayItems() {
        System.out.println("\nInventory Items:");

        for (Item item : items) {
            System.out.println(item);
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        inventory.addItem(new Item(101, "Laptop", 55000, 5));
        inventory.addItem(new Item(102, "Mouse", 800, 20));
        inventory.addItem(new Item(103, "Keyboard", 1500, 10));

        inventory.displayItems();

        System.out.println("\nSearching Item:");
        inventory.searchItem(102);

        System.out.println("\nUpdating Quantity:");
        inventory.updateQuantity(103, 15);

        inventory.displayItems();

        System.out.println("\nDeleting Item:");
        inventory.deleteItem(102);

        inventory.displayItems();

        System.out.println("\nTotal Inventory Value: ₹"
                + inventory.calculateInventoryValue());
    }
}