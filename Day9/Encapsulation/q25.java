package Encapsulation;

class MobilePhone {
    private String brand;
    private String model;
    private double price;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }
}

public class q25 {
    public static void main(String[] args) {
        MobilePhone phone = new MobilePhone();
        phone.setBrand("Samsung");
        phone.setModel("Galaxy S24");
        phone.setPrice(79999);
        System.out.println("Brand: " + phone.getBrand());
        System.out.println("Model: " + phone.getModel());
        System.out.println("Price: ₹" + phone.getPrice());
    }
}