import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GuessTests {
    @Test
    public void testPlay(){
        // Arrange
        var game = new Guess();
        var expected = false;
        
        // actual 
        boolean actual = game.play(10000);
        
        // Assert
        assertEquals(expected, actual);
    }
}
