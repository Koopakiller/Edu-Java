package de.hub.impl;

import de.hub.*;

public class Motorcycle extends Vehicle {
	public Motorcycle(double cylinderCapacity) {
		this.cylinderCapacity = cylinderCapacity;
	}

	public Motorcycle(double cylinderCapacity, String color) {
		this.color = color;
	}

	public double calculateMotorVehicleTax() {
		return Math.ceil(cylinderCapacity / 25) * 1.84;
	}
}
