package Question3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommissionEmployeeTests {
    @Test
    // test set gross sales
    public void setGrossSalesTest() {
        // arrange
        CommissionEmployee employee = new CommissionEmployee("Gilbert", "Ngandu", 123456789, 10000, 0.06);
        employee.setGrossSales(20000);
        int expected = 20000;
        // actual
        int actual = employee.getGrossSales();
        // Assert
        assertEquals(expected, actual);
    }

    // test set commission rate
    @Test
    public void setCommissionRateTest() {
        // arrange
        CommissionEmployee employee = new CommissionEmployee("Gilbert", "Ngandu", 123456789, 10000, 0.06);
        employee.setCommissionRate(0.1);
        double expected = 0.1;
        // actual
        double actual = employee.getCommissionRate();
        // Assert
        assertEquals(expected, actual, 0.0);
    }

    // test earnings
    @Test
    public void earningsTest() {
        // arrange
        CommissionEmployee employee = new CommissionEmployee("Gilbert", "Ngandu", 123456789, 10000, 0.06);

        double expected = 600.0;
        // actual
        double actual = employee.earnings();
        // Assert
        assertEquals(expected, actual, 0.0);
    }

   

}
