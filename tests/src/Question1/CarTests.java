import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Question1.Car;

public class CarTests {
    @Test
    // Test the getDistanceTraveled method
    public void testGetDistanceTraveled() {
        // arrange
        Car car = new Car(null, 100.0, 0, 0);
        double expected = 100.0;

        // act
        double actual = car.getDistanceTraveled();
        
        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the getCarbonFootprint method
    public void testGetCarbonFootprint() {
        // arrange
        Car car = new Car(null, 100, 0, 0);
        double expected = 0.33; 

        // act
        double actual = car.getCarbonFootprint(); 
        
        // assert
        assertEquals(expected, actual);
    }
}
