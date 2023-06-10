import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Question1.Building;

public class BuildingTests {
    @Test
    // Test the getElectricityConsumption method
    public void testGetElectricityConsumption() {
        // arrange
        Building building = new Building(100.0, 0.3929, 0, 0, 0, 0, 0);
        double expected = 0.04;  //

        // act
        double actual = building.getElectricity();
        
        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the getHeatingOilConsumption method
    public void testGetHeatingOilConsumption() {
        // arrange
        Building building = new Building(0, 0, 100.0, 0, 0, 0, 0);
        double expected = 0.02;

        // act
        double actual = building.getHeatingOil();
        
        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the getNaturalGasConsumption method
    public void testGetNaturalGasConsumption() {
        // arrange
        Building building = new Building(0, 0, 0, 100.0, 0, 0, 0);
        double expected = 100.0;

        // act
        double actual = building.getNaturalGas();
        
        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the getCoalConsumption method
    public void testGetCoalConsumption() {
        // arrange
        Building building = new Building(0, 0, 0, 0, 100.0, 0, 0);
        double expected = 100.0;

        // act
        double actual = building.getCoal();
        
        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the getPropaneConsumption method
    public void testGetPropaneConsumption() {
        // arrange
        Building building = new Building(0, 0, 0, 0, 0, 100.0, 0);
        double expected = 100.0;

        // act
        double actual = building.getPropane();
        
        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the getWoodenPelletsConsumption method
    public void testGetWoodenPelletsConsumption() {
        // arrange
        Building building = new Building(0, 0, 0, 0, 0, 0, 100.0);
        double expected = 100.0;

        // act
        double actual = building.getWoodenPellets();
        
        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the getCarbonFootprint method
    public void testGetCarbonFootprint() {
        // arrange
        Building building = new Building(100, 0.32, 100, 100, 100, 100, 100);
        double expected = 5.31; // 100 * 0.0033

        // act
        double actual = building.getCarbonFootprint(); 
        
        // assert
        assertEquals(expected, actual);
    }

}
