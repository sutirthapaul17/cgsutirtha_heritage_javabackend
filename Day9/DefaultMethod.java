
interface Drivable {

    // Abstract — must implement
    void accelerate(int speed);
    void brake();

    // Default method — provided implementation, can be overridden
    default void startGPS() {
        System.out.println("GPS system starting...");
        System.out.println("Fetching current location...");
    }

    // Default method — fuel check
    default String checkFuelLevel() {
        return "Fuel level: OK";  // generic default
    }
}

class Truck implements Drivable {
    @Override
    public void accelerate(int speed) {
        System.out.println("Truck accelerating to " + speed + " km/h slowly");
    }

    @Override
    public void brake() {
        System.out.println("Truck applying air brakes");
    }

    // Overrides default method
    @Override
    public String checkFuelLevel() {
        return "Diesel tank: 80% full — checking AdBlue too...";
    }
    // startGPS() is NOT overridden — uses default implementation
}
class Bicycle implements Drivable {

    @Override
    public void accelerate(int speed) {
        System.out.println("Pedalling at " + speed + " km/h");
    }
    @Override
    public void brake() {
        System.out.println("Bicycle hand brakes applied");
    }

    // Overrides default — bicycle has no GPS
    @Override
    public void startGPS() {
        System.out.println("No GPS on this bicycle!");
    }
}
public class DefaultMethod {
}
