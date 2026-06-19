
// Parent class
class Shape {

    protected String color;
    public Shape(String color) { this.color = color; }

    public void draw() {
        System.out.println("Drawing a generic shape in " + color);
    }

    public double area() { return 0.0; }
    public String describe() {
        return "Shape [color=" + color + ", area=" + area() + "]";
    }
}

class Circle extends Shape {
    private double radius;
    public Circle(String color, double radius) {
        super(color); this.radius = radius;
    }
    @Override
    public void draw() {
        System.out.println("Drawing Circle: radius=" + radius + ", color=" + color);
    }
    @Override
    public double area() { return Math.PI * radius * radius; }
}

class Rectangle extends Shape {

    private double width, height;
    public Rectangle(String color, double width, double height) {
        super(color); this.width = width; this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle: " + width + "x" + height + ", color=" + color);
    }

    @Override
    public double area() { return width * height; }
}

class Triangle extends Shape {
    private double base, height;
    public Triangle(String color, double base, double height) {
        super(color); this.base = base; this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Triangle: base=" + base + ", h=" + height + ", color=" + color);
    }

    @Override
    public double area() { return 0.5 * base * height; }
}










public class DrawingApp {
    public static void main(String[] args) {

        // All stored as Shape reference — actual objects differ
        Shape[] shapes = {
                new Circle("Red", 5.0),
                new Rectangle("Blue", 4.0, 6.0),
                new Triangle("Green", 3.0, 8.0),
        };
        new Circle("Yellow", 2.5);
        // Dynamic Dispatch — correct draw() called for each
        for (Shape s : shapes) {
            s.draw();      // JVM decides at RUNTIME which draw() to call
            System.out.println("  Area: " + String.format("%.2f", s.area()));
            System.out.println("  " + s.describe());
            System.out.println();
        }
    }
}

/* Output:
   Drawing Circle: radius=5.0, color=Red
     Area: 78.54
   Drawing Rectangle: 4.0x6.0, color=Blue
     Area: 24.00
   Drawing Triangle: base=3.0, h=8.0, color=Green
     Area: 12.00
   Drawing Circle: radius=2.5, color=Yellow
     Area: 19.63
*/

