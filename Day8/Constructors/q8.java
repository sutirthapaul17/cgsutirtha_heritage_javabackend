// Create a Rectangle class with length and width initialized through constructor and calculate area. 

package Constructors;

class Rectangle {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }
    void display() {
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Area: " + calculateArea());
    }
}

public class q8 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(10, 5);
        rect.display();
    }
}