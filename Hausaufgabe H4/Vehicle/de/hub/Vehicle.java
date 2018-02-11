package de.hub;

public abstract class Vehicle {
    protected String color;
    protected double cylinderCapacity; // Hubraum

    public double getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract double calculateMotorVehicleTax();

    public void printInfo() {
        System.out.println("I'm a " + this.getClass().getSimpleName() + ".");
    }
}