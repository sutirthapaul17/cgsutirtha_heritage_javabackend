class Person{
    void showPerson(){System.out.println("Person");}
}
class Teacher extends Person{
    void showTeacher(){System.out.println("Teacher");}
}
class HeadTeacher extends Teacher{
    void showHeadTeacher(){System.out.println("Head Teacher");}
}
public class SchoolManagement{
    public static void main(String[] args){
        HeadTeacher h=new HeadTeacher();
        h.showPerson();
        h.showTeacher();
        h.showHeadTeacher();
    }
}
