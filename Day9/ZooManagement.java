
// ABSTRACT CLASS — because animals share STATE and BEHAVIOUR
abstract class Animal {
    protected String name;
    protected int age;
    protected double weight;
    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    // Common concrete behaviour
    public void eat() {
        System.out.println(name + " is eating");
    }
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
    // Abstract — every animal makes a different sound
    public abstract void makeSound();
    public abstract String getAnimalType();
}

// INTERFACES — capabilities (CAN-DO)
interface Flyable {
    void fly();
    default void land() { System.out.println("Landing..."); }
}

interface Swimmable {
    void swim();
    int getSwimmingSpeed();
}

interface Trainable {
    void learnTrick(String trick);
    void performTrick(String trick);
}

// Eagle: extends Animal (IS-A Animal) + implements Flyable (CAN fly)
class Eagle extends Animal implements Flyable {

    public Eagle(String name) { super(name, 3, 4.5); }

    @Override
    public void makeSound()  { System.out.println(name + ": Screech!"); }

    @Override
    public String getAnimalType() { return "Bird"; }

    @Override
    public void fly() {
        System.out.println(name + " soars at 120 km/h");
    }
}

// Dolphin: IS-A Animal + CAN swim + CAN be trained
class Dolphin extends Animal implements Swimmable, Trainable {

    private java.util.List<String> tricks = new java.util.ArrayList<>();
    public Dolphin(String name) { super(name, 5, 150.0); }

    @Override
    public void makeSound() { System.out.println(name + ": Click click!"); }

    @Override
    public String getAnimalType() { return "Marine Mammal"; }

    @Override
    public void swim() { System.out.println(name + " swimming at " + getSwimmingSpeed() + " km/h"); }

    @Override
    public int getSwimmingSpeed() { return 60; }

    @Override
    public void learnTrick(String trick) {
        tricks.add(trick);
        System.out.println(name + " learned: " + trick);
    }
    @Override
    public void performTrick(String trick) {
        if (tricks.contains(trick)) System.out.println(name + " performs: " + trick + "!");
    }
}

// Duck: IS-A Animal + CAN fly + CAN swim
class Duck extends Animal implements Flyable, Swimmable {
    public Duck(String name) { super(name, 2, 1.2); }
    @Override public void makeSound() { System.out.println(name + ": Quack!"); }
    @Override public String getAnimalType() { return "Bird"; }
    @Override public void fly()  { System.out.println(name + " flies low over the pond"); }
    @Override public void swim() { System.out.println(name + " paddles across the pond"); }
    @Override public int getSwimmingSpeed() { return 5; }
}

public class ZooManagement {
}
