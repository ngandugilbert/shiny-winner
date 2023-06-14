package Question3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HourlyEmployeeTests {
    @Test
    // Test the get hours worked method
    public void getHoursWorkedTest() {
        // arrange
        HourlyEmployee employee = new HourlyEmployee("Gilbert", "Ngandu", 0, 12.5, 13);
        int expected = 13;
        // actual

        int actual = employee.getHoursWorked();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the get hourly wage worked method
    public void getHourlyWageTest() {
        // arrange
        HourlyEmployee employee = new HourlyEmployee("Gilbert", "Ngandu", 0, 12.5, 13);
        double expected = 12.5;
        // actual

        double actual = employee.getHourlyWage();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the set hours worked method
    public void setHoursTest() {
        // arrange
        HourlyEmployee employee = new HourlyEmployee("Gilbert", "Ngandu", 0, 12.5, 13);
        int expected = 40;
        employee.setHours(40);
        // actual

        int actual = employee.getHoursWorked();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the set hourly wage worked method
    public void setHourlyWageTest() {
        // arrange
        HourlyEmployee employee = new HourlyEmployee("Gilbert", "Ngandu", 0, 12.5, 13);
        double expected = 16.5;
        employee.setWage(16.5);
        // actual

        double actual = employee.getHourlyWage();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the earnings when hours worked is above 40 method
    public void earningsTestOne() {
        // arrange
        HourlyEmployee employee = new HourlyEmployee("Gilbert", "Ngandu", 0, 12.5, 60);
        double expected = 875.00;

        // actual

        double actual = employee.earnings();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the earnings when hours worked is below 40 case method
    public void earningsTestTwo() {
        // arrange
        HourlyEmployee employee = new HourlyEmployee("Gilbert", "Ngandu", 0, 12.5, 30);
        double expected = 375.0;

        // actual

        double actual = employee.earnings();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    // Test the earnings when hours worked is below 40 case method
    public void toStringTest() {
        // arrange
        HourlyEmployee employee = new HourlyEmployee("Gilbert", "Ngandu", 1, 12.5, 30);
       
        String expected = String.format("First Name: %s%nLast Name: %s%nSocial Security Number: %d%nHours Worked: %d%nHourly Wage: %.2f%nEarnings: %.2f","Gilbert", "Ngandu", 1, 30, 12.5,375.0);

        // actual

        String actual = employee.toString();

        // assert
        assertEquals(expected, actual);
    }

}
