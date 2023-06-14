package Question3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasePlusCommissionEmployeeTests {
    @Test
    // get base salary test
    public void setBaseSalaryTest() {
        // arrange
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee("Gilbert", "Ngandu", 123456789, 10000,
                0.06, 200);
        employee.setBaseSalary(300);
        double expected = 300.0;
        // actual
        double actual = employee.getBaseSalary();
        // Assert
        assertEquals(expected, actual, 0.0);
    }

    @Test
    // earnings test
    public void earningsTest() {
        // arrange
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee("Gilbert", "Ngandu", 123456789, 10000,
                0.06, 200);

        double expected = 800.0;
        // actual
        double actual = employee.earnings();
        // Assert
        assertEquals(expected, actual, 0.0);
    }

    // Create a base pluss earning toString test
    @Test
    public void toStringTest() {
        // arrange
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee("Gilbert", "Ngandu", 123456789, 10000,
                0.06, 200);

        String expected = String.format("Base Plus Commission Employee%nFirst Name: Gilbert%nLast Name: Ngandu%nSocial Security Number: 123456789%nGross Sales: 10000%nCommission Rate: 0.06%nBase Salary: 200.00%n");

        // actual
        String actual = employee.toString();
        // Assert
        assertEquals(expected, actual);
    }
}
