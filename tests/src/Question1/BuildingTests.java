import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import Question1.Building.Building;
import Question1.Building.BuildingEmitter;
import Question1.Building.EmitterEnum;

public class BuildingTests {
   
    // Test set emitters
    @Test
    public void testSetEmitter(){
        // Arrange
        var building = new Building();  // Create the building class object
        var  emitters = new ArrayList<BuildingEmitter>();

        emitters.add(new BuildingEmitter(10.0, EmitterEnum.ELECTRICITY_F));
        building.setEmitters(emitters); // set the building emitters

        var expected = emitters;

        // Actual
        var actual = building.getEmitters();

        // Assert
        assertEquals(expected, actual);
    }

    // Test set getCarbonfootprint
    @Test
    public void testGetCarbonFootprint(){
        // Arrange
        var building = new Building();  // Create the building class object
        var  emitters = new ArrayList<BuildingEmitter>();

        emitters.add(new BuildingEmitter(10.0, EmitterEnum.ELECTRICITY_F));
        building.setEmitters(emitters); // set the building emitters

        double expected = 5.0;

        // Actual
        double actual = building.getCarbonFootprint();

        // Assert
        assertEquals(expected, actual);
    }
}
