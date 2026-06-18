
// CLASS HIERARCHY

class Animal {

    public void eat() { System.out.println("Animal eating"); }

}

class Dog extends Animal {

    public void eat()  { System.out.println("Dog eating kibble"); }

    public void fetch() { System.out.println("Dog fetching ball!"); }

}

class Cat extends Animal {

    public void eat()  { System.out.println("Cat eating fish"); }

    public void purr()  { System.out.println("Cat purring..."); }

}



// ── UPCASTING (implicit, always safe) ──────────────────

public class TypeCasting {
    public static void main(String[] args) {
        Dog dog = new Dog();

        Animal a = dog;           // Upcast — Dog IS-A Animal

        a.eat();                  // → Dog eating kibble (polymorphism!)

// a.fetch();             // ❌ Cannot — Animal ref doesn't know fetch()



// ── DOWNCASTING (explicit, can fail) ───────────────────

        Animal animal = new Dog();       // upcast

        Dog d = (Dog) animal;            // downcast — SAFE: actual object IS a Dog

        d.fetch();                        // ✅ Works



        Animal animal2 = new Cat();

// Dog d2 = (Dog) animal2;       // ❌ ClassCastException at RUNTIME!

        // Actual object is Cat, not Dog



// ── SAFE PATTERN: instanceof BEFORE downcast ───────────

        Animal[] animals = { new Dog(), new Cat(), new Dog() };

        for (Animal an : animals) {

            if (an instanceof Dog) {

                Dog tempDog = (Dog) an;   // safe because we checked

                tempDog.fetch();

            } else if (an instanceof Cat) {

                Cat tempCat = (Cat) an;

                tempCat.purr();

            }

        }
    }
}
