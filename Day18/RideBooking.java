class Vehicle{
    void fare(){System.out.println("Generic Fare");}
}
class Car extends Vehicle{
    void fare(){System.out.println("Car Fare = Rs.200");}
}
class Bike extends Vehicle{
    void fare(){System.out.println("Bike Fare = Rs.100");}
}
public class RideBooking{
    public static void main(String[] args){
        Vehicle[] vehicles={new Car(),new Bike()};
        for(Vehicle v:vehicles){
            v.fare();
        }
    }
}
