

class Person { 
    String name; 
    int age; 
    Person(String name, int age) { 
        this.name = name; 
        this.age = age; 
        System.out.println("Person constructor called for: " + name); 
    }
    void introduce() { 
        System.out.println("Hi, I am " + name + ", aged " + age); 
    } 
}
class Employee extends Person { 
    String company; 
    double salary; 
    Employee(String name, int age, String company, double salary) { 
        super(name, age);   // MUST be the first statement! 
        this.company = company; 
        this.salary = salary; 
        System.out.println("Employee constructor called for: " + name); 
    } 
    void displayEmployee() { 
        super.introduce();  // Call parent method 
        System.out.println("Company: " + company + ", Salary: " + salary); 
    }
}
public class PersonMain { 
    public static void main(String[] args) { 
        Employee emp = new Employee("Alice", 30, "Google", 90000); 
        emp.displayEmployee(); 
    } 
} 