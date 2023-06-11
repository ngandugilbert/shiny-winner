import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Question1.Car;

public class CarTests {
    @Test
    // Test the getDistanceTraveled method
    public void testGetDistanceTraveled() {
        // arrange
        Car car = new Car("Shelby", 0.0, 100.0, 0);
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
        Car car = new Car("Land Rover", 50, 100, 0);
        double expected = 0; 

        // act
        double actual = car.getCarbonFootprint(); 
        
        // assert
        assertEquals(expected, actual);
    }

     @Test
    // Test the getCarbonFootprint method
    public void testGetCarbonFootprintDiesel() {
        // arrange
        Car car = new Car("Shelby", 100, 100, 1);
        double expected = 1014; 

        // act
        double actual = car.getCarbonFootprint(); 
        
        // assert
        assertEquals(expected, actual);
    }
}
