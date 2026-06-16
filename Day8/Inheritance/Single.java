package Inheritance;

//  Single Inheritance: Shape → Circle 
class Shape { 
    String color; 
    Shape(String color) { 
        this.color = color; 
    }
    void draw() { 
        System.out.println("Drawing a " + color + " shape."); 
    } 
} 

class Circle extends Shape { 
    double radius; 
    Circle(String color, double radius) { 
        super(color); 
        this.radius = radius; 
    } 
    double area() {
        return Math.PI * radius * radius;
    } 
    @Override 
    void draw() { 
        System.out.println("Drawing a " + color + " circle with radius " + radius); 
    } 
} 

public class Single { 
    public static void main(String[] args) { 
        Circle c = new Circle("Red", 5.0); 
        c.draw(); 
        System.out.println("Area: " + c.area()); 
    } 
}