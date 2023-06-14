package Question3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmployeeTests {

    @Test
    // Test the get first name method
    public void getFirstNameTest() {
        // arrange
        Employee employee = new Employee("Gilbert", "Ngandu", 0);
        String expected = "Gilbert";
        // actual

        String actual = employee.getFirstName();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the get last name method
    public void getLastNameTest() {
        // arrange
        Employee employee = new Employee("Gilbert", "Ngandu", 0);
        String expected = "Ngandu";
        // actual

        String actual = employee.getLastName();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the get social security number method
    public void getSocialSecurityNumberTest() {
        // arrange
        Employee employee = new Employee("Gilbert", "Ngandu", 0);
        int expected = 0;
        // actual

        int actual = employee.getSocialSecurityNumber();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void toStringTest() {
        // arrange
        Employee employee = new Employee("Gilbert", "Ngandu", 1);
        String expected = String.format("First Name: %s%nLast Name: %s%nSocial Security Number: %d%n","Gilbert", "Ngandu", 1);

        // act
        String actual = employee.toString();

        // assert
        assertEquals(expected, actual);
    }

}
