package Question3;

public class CommissionEmployee extends Employee {
    private int grossSales;
    private double commissionRate;

    public CommissionEmployee(String firstName, String lastName, int socialSecurityNumber, int grossSales,
            double commissionRate) {
        super(firstName, lastName, socialSecurityNumber);

        // if grossSales is invalid throw exception
        if (grossSales < 0)
            throw new IllegalArgumentException("Gross sales must be >= 0");

        // if commissionRate is invalid throw exception
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;

    }

    // set gross sales amount
    public void setGrossSales(int grossSales) {
        if (grossSales < 0)
            throw new IllegalArgumentException("Gross sales must be >= 0");
        this.grossSales = grossSales;
    }

    // return gross sales amount
    public int getGrossSales() {
        return grossSales;
    }

    // set commission rate
    public void setCommissionRate(double commissionRate) {
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException(
                    "Commission rate must be > 0.0 and < 1.0");

        this.commissionRate = commissionRate;
    }

    // return commission rate
    public double getCommissionRate() {
        return commissionRate;
    }

    // calculate earnings
    public double earnings() {
        return getCommissionRate() * getGrossSales();
    }

    // return String representation of CommissionEmployee object
    @Override
    public String toString() {
        return String.format("%sGross sales: %d%nCommission Rate: %.2f%n", super.toString(), getGrossSales(), getCommissionRate());
    }
} // end class CommissionEmployee
