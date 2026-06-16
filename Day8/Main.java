class Animal { 
    String name; 
    int age; 
    String sound; 
    Animal(String name, int age) { 
        this.name = name; 
        this.age = age; 
        System.out.println("Animal created: " + name);
    } 
    void eat() { 
        System.out.println(name + " is eating."); 
    } 
    void sleep() { 
        System.out.println(name + " is sleeping."); 
    } 
    void displayInfo() { 
        System.out.println("Name: " + name + ", Age: " + age); 
    } 
} 
// CHILD CLASS 1 — Dog inherits from Animal 
class Dog extends Animal { 
    String breed; 
    Dog(String name, int age, String breed) { 
        super(name, age);
        this.breed = breed; 
    }
    void bark() { 
        System.out.println(name + " says: Woof! Woof!"); 
    } 
} 
// CHILD CLASS 2 — Bird inherits from Animal 
class Bird extends Animal { 
    boolean canFly; 
    Bird(String name, int age, boolean canFly) { 
        super(name, age); 
        this.canFly = canFly; 
    } 
    void fly() { 
        if (canFly) 
            System.out.println(name + " is flying!"); 
        else 
            System.out.println(name + " cannot fly."); 
    } 
}
// MAIN CLASS 
public class Main { 
    public static void main(String[] args) { 
        Dog dog = new Dog("Bruno", 3, "Labrador"); 
        dog.eat();          // Inherited from Animal 
        dog.sleep();        // Inherited from Animal 
        dog.bark();         // Dog's own method 
        dog.displayInfo();  // Inherited from Animal 
        Bird bird = new Bird("Tweety", 2, true); 
        bird.eat();         // Inherited from Animal 
        bird.fly();         // Bird's own method 
    } 
} 