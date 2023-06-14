package Question3;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName,
            String lastName,
            int socialSecurityNumber,
            int grossSales,
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

    @Override
    // get earnings
    public double earnings() {
        return baseSalary + super.earnings();
    }

    @Override
    public String toString() {
        return String.format("Base Plus Commission Employee%n%sBase Salary: %.2f%n", super.toString(), getBaseSalary());
    }
}
