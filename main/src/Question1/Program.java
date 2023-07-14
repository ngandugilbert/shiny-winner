package Question1;

import java.text.DecimalFormat;
/*
 * Author: Gilbert Ng'andu
 * Task: Lab 4
 * References:
 *           1. https://www.carbonfootprint.com/calculator.aspx
 */
import java.util.ArrayList;

import Question1.Building.Building;
import Question1.Building.BuildingEmitter;
import Question1.Building.EmitterEnum;
import Question1.Car.Car;
import Question1.Car.FuelEnum;

/*
 * This is the main class that will run the program
 */
public class Program {
    public static void main(String[] args) {

        ArrayList<CarbonFootprint> producers = new ArrayList<CarbonFootprint>(); // create a list of producers
        Building building = new Building(); // create a building object

        ArrayList<BuildingEmitter> buildingSources = new ArrayList<>(); // create a list of emitters or sources

        // Add the emitters to the list
        buildingSources.add(new BuildingEmitter(100, EmitterEnum.HEATING_OIL_F));
        buildingSources.add(new BuildingEmitter(10, EmitterEnum.ELECTRICITY_F));
        buildingSources.add(new BuildingEmitter(100, EmitterEnum.NATURAL_GAS_F));
        buildingSources.add(new BuildingEmitter(100, EmitterEnum.PROPANE_F));

        // Set the emitters for the building
        building.setEmitters(buildingSources);

        // Add the producers to the list. Car, Building and Bicycle
        producers.add(new Car("Vitz", 8, 1500, FuelEnum.DIESEL)); // For a car
        producers.add(building); // For a Building
        producers.add(new Bicycle(100)); // For a bicycle

        // Display the details
        for (CarbonFootprint producer : producers) {
            display(producer);
        }
    }

    // Print details for the objects
    public static void display(CarbonFootprint producer) {
        if (producer instanceof Car) {
            // print details for cars
            Car mycar = (Car) producer; // Downcast the CarbonFootprint class to Car

            line();
            System.out.printf(
                    "Car Details%n%nModel: %s%nFuel Type: %s%nAverage Consumption: %.2f%nDistance Traveled: %.2f%n",
                    mycar.getModel(),
                    mycar.getFuelTypeName(),
                    mycar.getAverageConsumption(),
                    mycar.getDistanceTraveled());

            line();
            System.out.printf("Carbon Footprint: %.2f%n", mycar.getCarbonFootprint());
            line();

        } else if (producer instanceof Building) {
            // Print Building Details
            Building myBuilding = (Building) producer;
            

            // Create header for the display format
            System.out.println("Building Details\n\nSource Of Energy\tUnits\t\tRate\t\tCarbon Footprint");
            printFlatLine();

            var iterator = myBuilding.getEmitters().iterator(); // get iterator for emitters
            DecimalFormat decimalFormat = new DecimalFormat("0.0000"); // format the decimal places with 4 decimal

            // Iterate through the emitters and print the details using the iterator
            while (iterator.hasNext()) {
                var emitter = iterator.next();
                System.out.println(emitter.getEmitterName() + "\t\t" + emitter.getUnits() + "\t\t"
                        + decimalFormat.format(emitter.getEmitterFactor()) + "\t\t"
                        + decimalFormat.format(emitter.getFootprintUnit()));
            }
            // print the total carbon footprint
            System.out.printf("%n%nBuilding Carbon Footprint = %.2f%n", myBuilding.getCarbonFootprint());
            line();

        } else if (producer instanceof Bicycle) {
            // print for details for bicycle
            Bicycle myBicycle = (Bicycle) producer;

            System.out.print("Bicycle Details\n\nDistance Traveled: "
                    + myBicycle.getDistanceTraveled()
                    + "\n");

            System.out.printf("Carbon Footprint: %.2f%n", myBicycle.getCarbonFootprint());
            line();

        }
    }

    // Print line
    public static void line() {
        System.out.println("\n...........................................................................");
    }

    public static void printFlatLine() {
        System.out.print("__________________________________________________________________________\n");
    }
}
