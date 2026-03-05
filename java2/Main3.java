class Vehicle {
    
    String brand;

    
    Vehicle() {
        System.out.println("Vehicle created");
    }

    
    Vehicle(String brand) {
        this.brand = brand;
        System.out.println("Vehicle Brand: " + brand);
    }

    
    void startEngine() {
        System.out.println("Vehicle engine starts");
    }
}


class Car extends Vehicle {

    int doors;

    
    Car() {
        super();
        System.out.println("Car created");
    }

    
    Car(String brand) {
        super(brand);
    }

    
    Car(String brand, int doors) {
        super(brand);
        this.doors = doors;
    }

    
    @Override
    void startEngine() {
        System.out.println("Car engine starts with key or button");
    }
}


class Bike extends Vehicle {

    boolean hasGear;

    
    Bike() {
        super();
        System.out.println("Bike created");
    }

    
    Bike(String brand) {
        super(brand);
    }

    
    Bike(String brand, boolean hasGear) {
        super(brand);
        this.hasGear = hasGear;
    }

    
    @Override
    void startEngine() {
        System.out.println("Bike engine starts with self or kick");
    }
}


public class Main3 {
    public static void main(String[] args) {

        Car car1 = new Car("Toyota", 4);
        car1.startEngine();

        System.out.println();

        Bike bike1 = new Bike("Honda", true);
        bike1.startEngine();
    }
}