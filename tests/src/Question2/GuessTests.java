package Question2;

import static org.junit.Assert.assertEquals;
import java.awt.Color;
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
        String expected = "Enter your first guess.";
        
        // actual 
        String actual = game.getStatus();
        
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getColorTest(){
        // Arrange
        Guess game = new Guess();
         
        game.play(1000); 
        Color expected = Color.RED;
        
        // actual 
        Color actual = game.getColor();
        
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void getIsPlayTest(){
        // Arrange
        Guess game = new Guess();
         
        game.play(1000); 
        boolean expected = true;
        
        // actual 
        boolean actual = true;
        
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void truePlayTest(){
        // Arrange
        Guess game = new Guess();
         
        game.play(1000); 
        boolean expected = true;
        
        // actual 
        boolean actual = game.play(100);
        
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void falsePlayTest(){
        // Arrange
        Guess game = new Guess();
         
        game.play(1000); 
        boolean expected = false;
        
        // actual 
        boolean actual = game.play(10000);
        
        // Assert
        assertEquals(expected, actual);
    }
}
