class Animal {}
class Lion extends Animal {
    void roar(){ System.out.println("Lion roars"); }
}
class Elephant extends Animal {
    void trumpet(){ System.out.println("Elephant trumpets"); }
}
public class ZooManagement {
    public static void main(String[] args){
        Animal a=new Lion();
        if(a instanceof Lion){
            ((Lion)a).roar();
        }
        a=new Elephant();
        if(a instanceof Elephant){
            ((Elephant)a).trumpet();
        }
    }
}
