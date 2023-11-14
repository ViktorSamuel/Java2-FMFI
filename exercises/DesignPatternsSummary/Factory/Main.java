package Factory;

public class Main {
    public static void main(String[] args) {
        // Vytvorenie factory pre auto
        VehicleFactory carFactory = new CarFactory();
        Vehicle car = carFactory.createVehicle();
        car.design();
        car.manufacture();

        // Vytvorenie factory pre bicykel
        VehicleFactory bikeFactory = new BikeFactory();
        Vehicle bike = bikeFactory.createVehicle();
        bike.design();
        bike.manufacture();
    }
}
