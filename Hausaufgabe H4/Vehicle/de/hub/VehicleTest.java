package de.hub;

import de.hub.impl.Car;
import de.hub.impl.Motorcycle;

public class VehicleTest{
    public static void main(String[] args){
        Motorcycle m = new Motorcycle(10);
        Car c = new Car(10, 10, 10);

        System.out.println(m.toString());
        System.out.println(c.toString());
    }
}
