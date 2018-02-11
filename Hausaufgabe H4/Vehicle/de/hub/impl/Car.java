package de.hub.impl;

import de.hub.inf.CarIF;
import de.hub.Vehicle;

public class Car extends Vehicle implements CarIF {
	private int engineType; // Motorart: 0 = Benziner, 1 = Diesel
	private double co2Emission; // CO2-Ausstoß in g/km

	public Car(int engineType, double cylinderCapacity, double co2Emission) {
		this.engineType = engineType;
		this.cylinderCapacity = cylinderCapacity;
		this.co2Emission = co2Emission;
	}

	public Car(int engineType, double cylinderCapacity, double co2Emission, String color) {
		this.engineType = engineType;
		this.cylinderCapacity = cylinderCapacity;
		this.co2Emission = co2Emission;
		this.color = color;
	}

	public int getEngineType() {
		return engineType;
	}

	public double getCo2Emission() {
		return co2Emission;
	}

	public double calculateMotorVehicleTax() {
		double tax = (engineType == 0) ? 2.0 : 9.5;
		double _co2Emission = co2Emission - 95;
		if (_co2Emission < 0) {
			_co2Emission = 0;
		}
		return Math.ceil(cylinderCapacity / 100) * tax + _co2Emission * 2.0;
	}
}
