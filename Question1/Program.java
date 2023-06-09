
/*
 * Author: Gilbert Ng'andu
 * Task: Lab 4
 * Formulae source: 
 *              1. https://www.carbonfootprint.com/calculator.aspx
 * -
 */
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        // create an array that will hold the objects of the classes
        ArrayList<CarbonFootprint> producer = new ArrayList<CarbonFootprint>();

        producer.add(new Car("Vitz", 8, 1500, 4));
        producer.add(new Building(100, 0.3929, 100, 100, 100, 100, 100));

        display(producer.get(0));
        display(producer.get(1));
    }

    // Print details
    public static void display(CarbonFootprint myobject) {
        if (myobject instanceof Car) {
            // print for cars
            Car mycar = (Car) myobject;
            line();
            System.out.printf("Carbon Footprint: %.2f%n", mycar.getCarbonFootprint());
            line();
            System.out.printf(
                    "Car Details%n%nModel: %s%nFuel Type: %s%nAverage Consumption: %.2f%nDistance Traveled: %.2f%n",
                    mycar.getModel(), mycar.getFuelType(), mycar.getAverageConsumption(), mycar.getDistanceTraveled());
            line();
        } else if (myobject instanceof Building) {
            // print for building
            Building myBuilding = (Building) myobject;
            System.out.print(myBuilding.getCarbonFootprint());
        } else if (myobject instanceof Bicycle) {
            // print for bicycle

        }
    }

    // Print line
    public static void line() {
        System.out.println("------------------------------------");
    }
}
