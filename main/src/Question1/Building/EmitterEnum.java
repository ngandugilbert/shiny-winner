package Question1.Building;

public enum EmitterEnum {
    HEATING_OIL_F(0.0002, "Heating Oil"),
    ELECTRICITY_F(0.5, "Electricity"),
    COAL_F(0.0003, "Coal"),
    PROPANE_F(0.0015, "Propane    "),
    WOODEN_PELLETS_F(0.506, "Wooden Pellets"),
    NATURAL_GAS_F(0.0002, "Natural Gas");

    private double value;
    private String name;

    EmitterEnum(double value, String name) {
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
