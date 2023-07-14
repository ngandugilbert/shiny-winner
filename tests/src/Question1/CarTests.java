import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Question1.Car.Car;
import Question1.Car.FuelEnum;

public class CarTests {
    @Test
    // Test the getDistanceTraveled method
    public void testGetDistanceTraveled() {
        // arrange
        Car car = new Car("Shelby", 0.0, 100.0, FuelEnum.DIESEL);
        double expected = 100.0;

        // act
        double actual = car.getDistanceTraveled();
        
        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the getCarbonFootprint method
    public void testGetCarbonFootprintPetrol() {
        // arrange
        Car car = new Car("Land Rover", 50, 100, FuelEnum.PETROL);
        double expected = 11.5; 

        // act
        double actual = car.getCarbonFootprint(); 
        
        // assert
        assertEquals(expected, actual);
    }

     @Test
    // Test the getCarbonFootprint method
    public void testGetCarbonFootprintDiesel() {
        // arrange
        Car car = new Car("Shelby", 100, 100, FuelEnum.DIESEL);
        double expected = 26.8; 

        // act
        double actual = car.getCarbonFootprint(); 
        
        // assert
        assertEquals(expected, actual);
    }
}
