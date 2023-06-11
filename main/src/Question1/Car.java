package Question1;

// This is the cars class that calculates the carbon foot print from different cars
public class Car implements CarbonFootprint {
    private String model;
    private double averageConsumption;
    private double distanceTraveled;
    private int fuelFlag;

    private enum FuelType {
        PETROL, DIESEL, NOT_SPECIFIED
    }

    private FuelType fuelType;

    public Car(String model, double averageConsumption, double distanceTraveled, int fuelTypeFlag) {
        this.model = setModel(model);
        this.averageConsumption = setAverageConsumption(averageConsumption);
        this.distanceTraveled = setDistanceTraveled(distanceTraveled);
        this.fuelFlag = setFuelFlag(fuelTypeFlag);
        setFuelType(); // Update the fuel type before calculating the carbon foot print
    }

    private String setModel(String model) {
        // Validate the model
        String upperCaseModel = model.toUpperCase();
        return upperCaseModel;
    }

    public String getModel() {
        return this.model;
    }

    private double setAverageConsumption(double averageConsumption) {
        // Remember to add validations
        return averageConsumption;
    }

    public double getAverageConsumption() {
        return this.averageConsumption;
    }

    private double setDistanceTraveled(double distanceTraveled) {
        return distanceTraveled;
    }

    public double getDistanceTraveled() {
        return this.distanceTraveled;
    }

    public FuelType getFuelType() {
        return this.fuelType;
    }

    private int setFuelFlag(int fuelTypeFlag) {
        // Validate
        if (fuelTypeFlag >= 0 && fuelTypeFlag < 2) {
            return fuelTypeFlag;
        }
        return 10; // Error code
    }

    // Calculates the carbon foot print for the car
    @Override
    public double getCarbonFootprint() {
        // Calculates the carbon foot print
        double footPrint = 0;
        footPrint = calculateRate() * distanceTraveled;
        return footPrint;
    }

    // Calculate the rate for the type of fuel
    private double calculateRate() {

        final double PETROL_RATE = 8.89; // per 100km
        final double DIESEL_RATE = 10.14; // per 100km
        final int DISTANCE = 100;
        double rate = 0; // amount of CO2 produced per Km

        switch (this.fuelFlag) {
            case 1:
                // This is for diesel
                rate = (DIESEL_RATE * this.averageConsumption) / DISTANCE;
                return rate;

            case 2:
                // This is for petrol
                rate = (PETROL_RATE * this.averageConsumption) / DISTANCE;
                return rate;
            default:
                return rate;
        }
    }

    // update the fuel type
    private void setFuelType() {
        switch (this.fuelFlag) {
            case 0:
                // DIESEL
                this.fuelType = FuelType.DIESEL;
                break;
            case 1:
                // PETROL
                this.fuelType = FuelType.PETROL;
                break;
            case 10: // Error occured
                // for invalid type
                this.fuelType = FuelType.NOT_SPECIFIED;
                break;
        }
    }

}
