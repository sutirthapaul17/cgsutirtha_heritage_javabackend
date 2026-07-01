class Employee{
    String name;
    Employee(String name){
        this.name=name;
    }
    void displayDetails(){
        System.out.println("Employee: "+name);
    }
}
class Manager extends Employee{
    String department;
    Manager(String name,String department){
        super(name);
        this.department=department;
    }
    void display(){
        super.displayDetails();
        System.out.println("Department: "+department);
    }
}
public class CompanyHR{
    public static void main(String[] args){
        Manager m=new Manager("Alice","HR");
        m.display();
    }
}
