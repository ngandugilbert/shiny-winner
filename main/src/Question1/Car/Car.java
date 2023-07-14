/*
 * Author: Gilbert Ng'andu
 * references:
 *             1. https://chat.openai.com/share/5c2910b3-3127-4223-9d85-473b93a018b0
 */
package Question1.Car;

import Question1.CarbonFootprint;

// This is the cars class that calculates the carbon foot print from different cars
public class Car implements CarbonFootprint {
    private String model;
    private String fuelTypeName;
    private double averageConsumption;
    private double distanceTraveled;
    private FuelEnum fuelType;
    double footPrint;

    public Car(String model, double averageConsumption, double distanceTraveled, FuelEnum fuelType) {
        setModel(model);
        setAverageConsumption(averageConsumption);
        setDistanceTraveled(distanceTraveled);
        setFuelTypeName(fuelType);
        this.fuelType = fuelType;
        this.footPrint = 0;
    }

    // Set the model
    public void setModel(String model) {
        // Validate the model
        String upperCaseModel = model.toUpperCase();
        this.model = upperCaseModel;
    }

    // Get the model
    public String getModel() {
        return this.model;
    }

    // Set the fuel type
    public void setAverageConsumption(double averageConsumption) {
        if (isDataValid(averageConsumption))
            this.averageConsumption = averageConsumption;
    }

    // Get the average consumption
    public double getAverageConsumption() {
        return this.averageConsumption;
    }

    // Set the distance traveled
    public void setDistanceTraveled(double distanceTraveled) {
        if (isDataValid(distanceTraveled))
            this.distanceTraveled = distanceTraveled;
    }

    // Get the distance traveled
    public double getDistanceTraveled() {
        return this.distanceTraveled;
    }

    // Set the fuel type name
    public void setFuelTypeName(FuelEnum fuelType) {
        this.fuelTypeName = fuelType.getName();
    }

    // Get the fuel type name
    public String getFuelTypeName() {
        return this.fuelTypeName;
    }

    // Calculates the carbon foot print for the car
    @Override
    public double getCarbonFootprint() {
        // Calculates the carbon foot print
        footPrint = this.fuelType.getValue() * averageConsumption * distanceTraveled;
        return footPrint;
    }

    // validate the average consumption
    private boolean isDataValid(double averageConsumption) {
        if (averageConsumption < 0)
            return false;
        return true;
    }

}
