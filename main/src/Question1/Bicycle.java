/*
 * Bicycle.java
*  Author: Gilbert Ng'andu
 */
package Question1;

public class Bicycle implements CarbonFootprint {
    // calculating the carbon footprint for the bicycle
    private final double FOOT_PRINT_RATIO = 0.0033;
    private double distanceCycled;
    private double carbonFootPrint;

    public Bicycle(double distanceCycled) {
        this.distanceCycled = distanceCycled;
        this.carbonFootPrint = 0;
    }

    // get the distance cycled
    public double getDistanceTraveled() {
        return this.distanceCycled;
    }

    // Set the distance cycled
    public void setDistanceTraveled(double distanceCycled) {
        this.distanceCycled = distanceCycled;
    }

    // Calculate the carbon foot print
    @Override
    public double getCarbonFootprint() {
        this.carbonFootPrint = this.distanceCycled * FOOT_PRINT_RATIO;
        return this.carbonFootPrint;
    }

}
