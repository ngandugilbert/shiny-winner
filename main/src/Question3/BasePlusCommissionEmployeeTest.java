package Question3;

// BasePlusCommissionEmployee test program.
public class BasePlusCommissionEmployeeTest {

    public static void main(String[] args) {
        // instantiate BasePlusCommissionEmployee object
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee("Gilbert", "Ngandu", 0, 5000, 0.04, 3000);

        // get base-salaried commission employee data
        System.out.printf(
                "Employee information obtained by get methods:%n");
        System.out.printf("%s %s%n", "First name is", employee.getFirstName());
        System.out.printf("%s %s%n", "Last name is", employee.getLastName());
        System.out.printf("%s %s%n", "Social security number is", employee.getSocialSecurityNumber());
        System.out.printf("%s %d%n", "Gross sales is", employee.getGrossSales());
        System.out.printf("%s %.2f%n", "Commission rate is", employee.getCommissionRate());
        System.out.printf("%s %.2f%n", "Base salary is", employee.getBaseSalary());

        // Modified base salary
        employee.setBaseSalary(1000);

        System.out.printf("%n%s:%n%n%s%n",
                "Updated employee information obtained by toString", employee);
    } // end main
} // end class BasePlusCommissionEmployeeTest