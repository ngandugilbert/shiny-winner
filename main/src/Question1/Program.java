package Question1;
/*
 * Author: Gilbert Ng'andu
 * Task: Lab 4
 * References:
 *           1. https://www.carbonfootprint.com/calculator.aspx
 * -
 */
import java.util.ArrayList;

/*
 * This is the main class that will run the program
 */
public class Program {
    public static void main(String[] args) {
        // create an array that will hold the objects of the classes
        ArrayList<CarbonFootprint> producer = new ArrayList<CarbonFootprint>();

        producer.add(new Car("Vitz", 8, 1500, 1));

        producer.add(new Building(100, 0.3929, 100, 100, 100, 100, 100));
        
        producer.add(new Bicycle(100));

        // Display the details
        for (CarbonFootprint myobject : producer) {
            display(myobject);
        }
    }

    // Print details for the objects
    public static void display(CarbonFootprint myobject) {
        if (myobject instanceof Car) {
            // print for cars
            Car mycar = (Car) myobject;

            line();
            System.out.printf(
                    "Car Details%n%nModel: %s%nFuel Type: %s%nAverage Consumption: %.2f%nDistance Traveled: %.2f%n",
                    mycar.getModel(),
                    mycar.getFuelType(),
                    mycar.getAverageConsumption(),
                    mycar.getDistanceTraveled());

            line();
            System.out.printf("Carbon Footprint: %.2f%n", mycar.getCarbonFootprint());
            line();

        } else if (myobject instanceof Building) {
            // print for building carbon footprint
            Building myBuilding = (Building) myobject;

            System.out.printf(
                    "Building Details%n%nElectricity Bill: %.2f @%.2f%nHeating Oil Units: %.2f%nNatural Gas Units: %.2f%nCoal Units: %.2f%nPropane Units: %.2f%nWooden Pellets: %.2f%n",
                    myBuilding.getElectricity(),
                    myBuilding.getElectricityFactor(),
                    myBuilding.getHeatingOil(),
                    myBuilding.getNaturalGas(),
                    myBuilding.getCoal(),
                    myBuilding.getPropane(),
                    myBuilding.getWoodenPellets());
            line();
            System.out.printf("Carbon Footprint: %.2f%n", myBuilding.getCarbonFootprint());
            line();

        } else if (myobject instanceof Bicycle) {
            // print for bicycle
            Bicycle myBicycle = (Bicycle) myobject;

            System.out.print("Bicycle Details\n\nDistance Traveled: "
                    + myBicycle.getDistanceTraveled()
                    + "\n");
                    
            line();
            System.out.printf("Carbon Footprint: %.2f%n", myBicycle.getCarbonFootprint());
            line();

        }
    }

    // Print line
    public static void line() {
        System.out.println("------------------------------------");
    }
}
