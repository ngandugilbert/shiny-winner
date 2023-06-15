package Question2;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GuessTests {
    @Test
    public void testPlay(){
        // Arrange
        Guess game = new Guess();
        var expected = false;
        
        // actual 
        boolean actual = game.play(10000);
        
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getStatusTest(){
        // Arrange
        Guess game = new Guess();
        game.play(10000);
        var expected = "Guess a number between 1 and 1000";
        
        // actual 
        String actual = game.getStatus();
        
        // Assert
        assertEquals(expected, actual);
    }
}
