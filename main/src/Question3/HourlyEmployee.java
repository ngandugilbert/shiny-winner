package Question3;

public class HourlyEmployee extends Employee {
    private int hoursWorked;
    private double hourlyWage;

    public HourlyEmployee(String firstName, String lastName, int socialSecurityNumber, double hourlyWage,
            int hoursWorked) {
        super(firstName, lastName, socialSecurityNumber);
        setHours(hoursWorked); // Set the hours worked
    }

    // get hours worked
    public int getHoursWorked() {
        return this.hoursWorked;
    }

    // get hourly wage
    public double getHourlyWage() {
        return this.hourlyWage;
    }

    // Set the hours worked
    public void setHours(int hoursWorked) {
        if (hoursWorked < 0 || hoursWorked > 168)
            throw new IllegalArgumentException("Hours worked must be between 0 and 168");

        this.hoursWorked = hoursWorked;
    }

    // set wage
    public void setWage(double hourlyWage) {

        if (hourlyWage < 0)
            throw new IllegalArgumentException("Hourly wage can not be negative. Please try again.");
        // accept
        this.hourlyWage = hourlyWage;

    }

    // get earnings
    public double earnings() {
        final double WAGE_RATE = 1.5;
        final int MIN_INCREASE_HOURS = 40;
        double increasedAmount = 0.0;
        double amountEarned = 0.0;

        int hours = getHoursWorked();

        if (hours > MIN_INCREASE_HOURS) {
            // If the hours worked are more than 40
            // Calculate the earnings with 1.5 times the hours worked
            increasedAmount = (((hours - MIN_INCREASE_HOURS) * WAGE_RATE) * getHourlyWage())
                    + MIN_INCREASE_HOURS * getHourlyWage();
            return increasedAmount;

        } else {
            amountEarned = hours * getHourlyWage();
            return amountEarned;
        }

    }

    @Override
    public String toString() {
        return String.format("%sHours Worked: %d%nHourly Wage: %.2f%n",
            super.toString(),
            getHoursWorked(),
            getHourlyWage());
    }

}
