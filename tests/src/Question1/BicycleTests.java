import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Question1.Bicycle;

public class BicycleTests {
    @Test
    // Test the getDistanceTraveled method
    public void testGetDistanceTraveled() {
        // arrange
        Bicycle bicycle = new Bicycle(100.0);
        double expected = 100.0;

        // act
        double actual = bicycle.getDistanceTraveled();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the getCarbonFootprint method
    public void testGetCarbonFootprint() {
        // arrange
        Bicycle bicycle = new Bicycle(100);
        double expected = 0.33; // 100 * 0.0033

        // act
        double actual = bicycle.getCarbonFootprint();

        // assert
        assertEquals(expected, actual);
    }
}
