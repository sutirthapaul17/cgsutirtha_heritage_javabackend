public class SchoolStudent { 

   
    int rollNumber; 
    String name; 

    static String schoolName = "Green Valley High School"; 

    SchoolStudent(int rollNumber, String name) { 
        this.rollNumber = rollNumber; 
        this.name = name; 

    } 

  

    void calculateFee() { 

        double baseFee = 5000.0; 
        double discount = 0.10; 
        double finalFee = baseFee - (baseFee * discount); 

        System.out.println(name + " (Roll No: " + rollNumber + ") studies at " 

                + schoolName + ". Fee payable: " + finalFee); 

    } 

  

    public static void main(String[] args) { 

        SchoolStudent s1 = new SchoolStudent(101, "Meera"); 

        SchoolStudent s2 = new SchoolStudent(102, "Arjun"); 

        s1.calculateFee(); 
        s2.calculateFee(); 

        SchoolStudent.schoolName = "Sunrise International School"; 

        s1.calculateFee(); 
        s2.calculateFee(); 

    } 

} 