package Question1.Car;

public enum FuelEnum {
    PETROL(0.00231, "Petrol"),
    DIESEL(0.00268, "Diesel");

    private double value;
    private String name;

    FuelEnum(double value, String name) {
        this.value = value;
        this.name = name;
    }

    double getValue() {
        return this.value;
    }

    String getName() {
        return this.name;
    }
}
