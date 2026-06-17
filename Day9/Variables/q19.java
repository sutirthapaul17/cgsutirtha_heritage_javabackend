package Variables;

class Employee2 {
    int id;
    String name;
    static String companyName = "TCS";

    Employee2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Company: " + companyName);
        System.out.println();
    }
}

public class q19 {
    public static void main(String[] args) {
        Employee2 e1 = new Employee2(1, "Rahul");
        Employee2 e2 = new Employee2(2, "Amit");

        e1.display();
        e2.display();
    }
}