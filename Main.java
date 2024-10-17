// Абстрактный класс
abstract class Vehicle {
    protected String brand;
    protected String model;
    private static int totalVehicles = 0;

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
        totalVehicles++;
    }

    public abstract void start();
    public abstract void stop();

    public static int getTotalVehicles() {
        return totalVehicles;
    }
}

// Интерфейсы
interface ElectricVehicle {
    void chargeBattery();
}

interface CombustionEngine {
    void refuel();
}

// Класс Car
class Car extends Vehicle implements CombustionEngine {
    private int numberOfDoors;
    private double engineCapacity;

    public Car(String brand, String model, int numberOfDoors, double engineCapacity) {
        super(brand, model);
        this.numberOfDoors = numberOfDoors;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void start() {
        System.out.println(brand + " " + model + " with " + engineCapacity + "L engine starts.");
    }

    @Override
    public void stop() {
        System.out.println(brand + " " + model + " stops.");
    }

    @Override
    public void refuel() {
        System.out.println(brand + " " + model + " is refueled.");
    }

    public void openTrunk() {
        System.out.println("Trunk is open.");
    }
}

// Класс Motorcycle
class Motorcycle extends Vehicle {
    private boolean hasSidecar;
    private double engineCapacity;

    public Motorcycle(String brand, String model, boolean hasSidecar, double engineCapacity) {
        super(brand, model);
        this.hasSidecar = hasSidecar;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void start() {
        System.out.println(brand + " " + model + " starts.");
    }

    @Override
    public void stop() {
        System.out.println(brand + " " + model + " stops.");
    }

    public void doWheelie() {
        System.out.println(brand + " " + model + " does a wheelie!");
    }
}

// Класс ElectricCar
class ElectricCar extends Car implements ElectricVehicle {
    private int batteryCapacity;

    public ElectricCar(String brand, String model, int numberOfDoors, double engineCapacity, int batteryCapacity) {
        super(brand, model, numberOfDoors, engineCapacity);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void chargeBattery() {
        System.out.println(brand + " " + model + " is charging its battery.");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 4, 2.5);
        car.start();
        car.refuel();
        car.stop();

        ElectricCar tesla = new ElectricCar("Tesla", "Model S", 4, 0, 100);
        tesla.start();
        tesla.chargeBattery();
        tesla.stop();

        Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Sportster", false, 1.2);
        motorcycle.start();
        motorcycle.doWheelie();
        motorcycle.stop();

        System.out.println("Total vehicles created: " + Vehicle.getTotalVehicles());
    }
}
