package de.hub.inf;

public interface CarIF {

    public int getEngineType();

    public double getCylinderCapacity();

    public double getCo2Emission();

    public void setColor(String color);

    public String getColor();

    public double calculateMotorVehicleTax();

    public void printInfo();
}