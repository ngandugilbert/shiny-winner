package Question1;

public class Building implements CarbonFootprint {
    private double electricity;
    private double electricityFactor;
    private double heatingOil;
    private double naturalGas;
    private double coal;
    private double propane;
    private double woodenPellets;

    // constructor
    public Building(double electricityUnits, double electricityFactor, double heatingOilUnits, double naturalGasUnits,
            double coalUnits, double propaneUnits, double woodenPelletsUnits) {
        setElectricity(electricityUnits, electricityFactor);
        setHeatingOil(heatingOilUnits);
        setNaturalGas(naturalGasUnits);
        setCoal(coalUnits);
        setPropane(propaneUnits);
        setWoodenPellets(woodenPelletsUnits);
        this.electricityFactor = electricityFactor;
    }

    // set the electricity variable
    public void setElectricity(double unit, double factor) {
        factor = factor / 1000;
        this.electricity = calculateEmission(unit, factor);
    }

    // set the heating oil
    public void setHeatingOil(double unit) {
        final double FACTOR = 0.0002;
        this.heatingOil = calculateEmission(unit, FACTOR);
    }

    // set the natural gas
    public void setNaturalGas(double unit) {
        final double FACTOR = 0.0002;
        this.naturalGas = calculateEmission(unit, FACTOR);
    }

    // set the coal
    public void setCoal(double unit) {
        final double FACTOR = 0.0003;
        this.coal = calculateEmission(unit, FACTOR);
    }

    // set the propane
    public void setPropane(double unit) {
        final double FACTOR = 0.0015;
        this.propane = calculateEmission(unit, FACTOR);
    }

    // set the wooden pellets
    public void setWoodenPellets(double unit) {
        final double FACTOR = 0.0506;
        this.woodenPellets = calculateEmission(unit, FACTOR);
    }

    // get the electricity
    public double getElectricity() {
        return this.electricity;
    }

    // get the heating oil
    public double getHeatingOil() {
        return this.heatingOil;
    }

    // get the natural gas
    public double getNaturalGas() {
        return this.naturalGas;
    }

    // get the coal
    public double getCoal() {
        return this.coal;
    }

    // get the propane
    public double getPropane() {
        return this.propane;
    }

    // get the wooden pellets
    public double getWoodenPellets() {
        return this.woodenPellets;
    }

    // get the electricity factor
    public double getElectricityFactor() {
        return this.electricityFactor;
    }

    // calculate the emission
    private double calculateEmission(double unit, double factor) {
        return unit * factor;
    }

    // calculate the carbon footprint
    @Override
    public double getCarbonFootprint() {
        double footPrint = 0; // metric tons of CO2e
        footPrint = this.coal + this.electricity + this.heatingOil + this.naturalGas + this.propane
                + this.woodenPellets;
        return footPrint;
    }
}
