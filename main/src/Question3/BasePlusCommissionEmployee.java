package Question3;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName,
            String lastName,
            int socialSecurityNumber,
            double grossSales,
            double commissionRate,
            double baseSalary) {

        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

        // if baseSalary is invalid throw exception
        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");

        this.baseSalary = baseSalary;
    }

    // set base salary
    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0.0)
            throw new IllegalArgumentException(
                    "Base salary must be >= 0.0");

        this.baseSalary = baseSalary;
    }

    // return base salary
    public double getBaseSalary() {
        return baseSalary;
    }

    // get earnings
    public double earnings() {
        return baseSalary + (getCommissionRate() * getGrossSales());
    }

    // return String representation of BasePlusCommissionEmployee
    @Override
    public String toString() {
        return String.format(
                "%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f", "base-salaried commission employee", getFirstName(),
                getLastName(),"social security number", getSocialSecurityNumber(), "gross sales", getGrossSales(), "commission rate", getCommissionRate(), "base salary",
                baseSalary);
    }
}
