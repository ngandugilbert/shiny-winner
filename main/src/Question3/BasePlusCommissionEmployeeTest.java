package Question3;

// BasePlusCommissionEmployee test program.
public class BasePlusCommissionEmployeeTest {

    public static void main(String[] args) {
        // instantiate BasePlusCommissionEmployee object
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee("Gilbert", "Ngandu", 0, 5000, 0.04, 3000);

        // get base-salaried commission employee data
        System.out.printf(
                "Employee information obtained by get methods:%n");
        System.out.printf("%s %s%n", "First name: ", employee.getFirstName());
        System.out.printf("%s %s%n", "Last name: ", employee.getLastName());
        System.out.printf("%s %s%n", "Social security number: ", employee.getSocialSecurityNumber());
        System.out.printf("%s %d%n", "Gross sales: ", employee.getGrossSales());
        System.out.printf("%s %.2f%n", "Commission rate: ", employee.getCommissionRate());
        System.out.printf("%s %.2f%n", "Base salary: ", employee.getBaseSalary());

        // Modified base salary
        employee.setBaseSalary(1000);

        System.out.printf("%n%s:%n%n%s%n",
                "Updated employee information obtained by toString", employee);
    } // end main
} // end class BasePlusCommissionEmployeeTest