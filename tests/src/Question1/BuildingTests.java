import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Question1.Building;

public class BuildingTests {
    @Test
    // Test the getElectricityConsumption method.
    // The electricity carbon footprint
    public void testGetElectricityConsumptionFootprint() {
        // arrange
        Building building = new Building(100.0, 0.3929, 0, 0, 0, 0, 0);
        double expected = 0.04; //

        // act
        double actual = building.getElectricity();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the getHeatingOilConsumption method, which it the carbon footprint of heating oil
    public void testGetHeatingOilConsumptionFootprint() {
        // arrange
        Building building = new Building(0, 0, 100.0, 0, 0, 0, 0);
        double expected = 0.02;

        // act
        double actual = building.getHeatingOil();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the getNaturalGasConsumption method, which it the carbon footprint of natural gas
    public void testGetNaturalGasFootprint() {
        // arrange
        Building building = new Building(0, 0, 0, 100.0, 0, 0, 0);
        double expected = 0.02;

        // act
        double actual = building.getNaturalGas();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the getCoalConsumption method, which it the carbon footprint of coal
    public void testGetCoalConsumptionFootprint() {
        // arrange
        Building building = new Building(0, 0, 0, 0, 100.0, 0, 0);
        double expected = 0.03;

        // act
        double actual = building.getCoal();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the getPropaneConsumption method, which it the carbon footprint of propane
    public void testGetPropaneConsumptionFootprint() {
        // arrange
        Building building = new Building(0, 0, 0, 0, 0, 100.0, 0);
        double expected = 0.15;

        // act
        double actual = building.getPropane();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the getWoodenPellets method, which it the carbon footprint of wooden pellets
    public void testGetWoodenPelletsFootprint() {
        // arrange
        Building building = new Building(0, 0, 0, 0, 0, 0, 100.0);
        double expected = 5.06;

        // act
        double actual = building.getWoodenPellets();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the getCarbonFootprint method, which it the carbon footprint of the building
    // The carbon footprint of the building is the sum of the carbon footprint of all the energy sources
    public void testGetCarbonFootprint() {
        // arrange
        Building building = new Building(100, 0.32, 100, 100, 100, 100, 100);
        double expected = 5.31;

        // act
        double actual = building.getCarbonFootprint();

        // assert
        assertEquals(expected, actual);
    }

}
