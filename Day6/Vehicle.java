public class Vehicle { 

    String name; 
    static int vehicleCount = 0; 

    Vehicle(String name) { 
        this.name = name; 
        vehicleCount++;
    } 

    static int getVehicleCount() { 
        return vehicleCount; 
    }

    public static void main(String[] args) { 

        Vehicle v1 = new Vehicle("Bike"); 
        Vehicle v2 = new Vehicle("Car"); 
        Vehicle v3 = new Vehicle("Truck"); 
       
        System.out.println("Total vehicles created: " + Vehicle.getVehicleCount()); 

    } 

} 