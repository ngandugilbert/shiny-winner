package Question2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Question2.data.Account.Database;

public class DatabaseTests {
    // if success, retrieve user info
    @Test
    public void testConnection(){
        // arrange
        var conn = new Database();
        conn.connect();
        var expected = true;
        
        // actual
        var actual = conn.login("Gilbert", "ngandu123");
        // assert
        conn.disconnect();
        assertEquals(expected, actual);
    }

     @Test
    public void testCreateAccount(){
        // arrange
        var conn = new Database();
        conn.connect();
        var expected = true;
        
        // actual
        var actual = conn.login("Gilbert", "ngandu123");
        // assert
        conn.disconnect();
        assertEquals(expected, actual);
    }
}
