package Question3;

// CommissionEmployee class test program.
public class HourlyEmployeeTest {
  public static void main(String[] args) {
    // instantiate CommissionEmployee object

    HourlyEmployee employee = new HourlyEmployee("Gilbert", "Ngandu", 0, 12.5, 60);

    // get commission employee data
    System.out.println(
        "Employee information obtained by get methods:");
    System.out.printf("%n%s %s%n", "First name is", employee.getFirstName());
    System.out.printf("%s %s%n", "Last name is", employee.getLastName());
    System.out.printf("%s %s%n", "Social security number is", employee.getSocialSecurityNumber());
    System.out.printf("%s %.2f%n", "Hourly Wage", employee.getHourlyWage());
    System.out.printf("%s %d%n", "Commission rate is", employee.getHoursWorked());
    System.out.printf("%s %.2f%n", "earnings is", employee.earnings());

    employee.setHours(90);
    employee.setWage(50);

    System.out.printf("%n%s:%n%n%s%n",
        "Updated employee information obtained by toString", employee);
  } // end main
}
