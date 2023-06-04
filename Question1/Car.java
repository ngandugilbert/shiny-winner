// This is the cars class that calculates the carbon foot print from different cars

public class Car implements CarbonFootprint {
    private String model;
    private double averageConsumption;
    private double distanceTraveled;
    private int fuelFlag;

    private enum FuelType {
        PETROL, DIESEL
    }

    private FuelType fuelType;

    public Car(){
        // Default constructor
    }
    public Car(String model, double averageConsumption, double distanceTraveled, int fuelFlag) {
        this.model = model;
        this.averageConsumption = averageConsumption;
        this.distanceTraveled = distanceTraveled;
        this.fuelFlag = fuelFlag;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public void setAverageConsumption(double averageConsumption) {
        // Remember to add validations
        this.averageConsumption = averageConsumption;
    }

    public double getAverageConsumption() {
        return this.averageConsumption;
    }

    public void setDistanceTraveled(double distancetraveled) {
        this.distanceTraveled = distancetraveled;
    }

    public double getDistanceTraveled() {
        return this.distanceTraveled;
    }

    public FuelType getFuelType() {
        return this.fuelType;
    }

    public void setFuelFlag(int flag) {
        // Validate
        if (flag > 0 && flag <= 2) {
            this.fuelFlag = flag;
        }
    }

    // Calculates the carbon foot print for the car
    @Override
    public double getCarbonFootprint() {
        // Calculates the carbon foot print
        double footPrint = 0;

        footPrint = calculateRate()*distanceTraveled;
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
                updateFuelType();
                rate = (DIESEL_RATE * this.averageConsumption) / DISTANCE;
                return rate;

            case 2:
                // This is for petrol
                updateFuelType();
                rate = (PETROL_RATE * this.averageConsumption) / DISTANCE;
                return rate;
            default:
                return rate;
        }
    }

    // update the fuel type
    private void updateFuelType() {
        if (this.fuelFlag == 1) {
            this.fuelType = FuelType.DIESEL;
        } else if (fuelFlag == 2) {
            this.fuelType = FuelType.PETROL;
        }
    }

}
