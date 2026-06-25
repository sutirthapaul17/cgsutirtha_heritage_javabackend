import java.util.ArrayList;

class Product {
    private int productId;
    private String productName;
    private double price;

    public Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return productId + " - " + productName + " ($" + price + ")";
    }
}

class Cart {
    private ArrayList<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getProductName() + " added to cart.");
    }

    public void removeProduct(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == productId) {
                System.out.println(products.get(i).getProductName()
                        + " removed from cart.");
                products.remove(i);
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }
    public double calculateTotal() {
        double total = 0;

        for (Product product : products) {
            total += product.getPrice();
        }

        return total;
    }

    public double applyDiscount(double discountPercent) {
        double total = calculateTotal();
        return total - (total * discountPercent / 100);
    }

    public void printInvoice(double discountPercent) {
        System.out.println("\n===== INVOICE =====");

        for (Product product : products) {
            System.out.println(product);
        }

        double total = calculateTotal();
        double finalAmount = applyDiscount(discountPercent);

        System.out.println("--------------------");
        System.out.println("Total Amount : $" + total);
        System.out.println("Discount     : " + discountPercent + "%");
        System.out.println("Payable Amt  : $" + finalAmount);
        System.out.println("====================");
    }
}

class Customer {
    private int customerId;
    private String customerName;
    private Cart cart;

    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.cart = new Cart();
    }

    public String getCustomerName() {
        return customerName;
    }

    public Cart getCart() {
        return cart;
    }
}

public class OnlineShoppingCart {
    public static void main(String[] args) {

        Product p1 = new Product(101, "Laptop", 55000);
        Product p2 = new Product(102, "Mouse", 800);
        Product p3 = new Product(103, "Keyboard", 1500);

        Customer customer = new Customer(1, "Rahul");

        Cart cart = customer.getCart();

        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);

        cart.removeProduct(102);

        cart.printInvoice(10);
    }
}