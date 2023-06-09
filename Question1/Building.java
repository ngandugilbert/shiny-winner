public class Building implements CarbonFootprint {
    private double electricity;
    private double heatingOil;
    private double naturalGas;
    private double coal;
    private double propane;
    private double woodenPellets;

    public Building(double electricityUnits, double electricityFactor, double heatingOilUnits, double naturalGasUnits,
            double coalUnits, double propaneUnits, double woodenPelletsUnits) {
        setElectricity(electricityUnits, electricityFactor);
        setHeatingOil(heatingOilUnits);
        setNaturalGas(naturalGasUnits);
        setCoal(coalUnits);
        setPropane(propaneUnits);
        setWoodenPellets(woodenPelletsUnits);
    }

    // set the electricity variable
    public void setElectricity(double unit, double factor) {
        factor = factor/1000;
        this.electricity = calculateEmission(unit, factor);
    }

    public void setHeatingOil(double unit) {
        final double FACTOR = 0.0002;
        this.heatingOil = calculateEmission(unit, FACTOR);
    }

    public void setNaturalGas(double unit) {
        final double FACTOR = 0.0002;
        this.naturalGas = calculateEmission(unit, FACTOR);
    }

    public void setCoal(double unit) {
        final double FACTOR = 0.0003;
        this.coal = calculateEmission(unit, FACTOR);
    }

    public void setPropane(double unit) {
        final double FACTOR = 0.0015;
        this.propane = calculateEmission(unit, FACTOR);
    }

    public void setWoodenPellets(double unit) {
        final double FACTOR = 0.0506;
        this.woodenPellets = calculateEmission(unit, FACTOR);
    }

    public double getElectricity() {
        return this.electricity;
    }

    public double getHeatingOil() {
        return this.heatingOil;
    }

    public double getNaturalGas() {
        return this.naturalGas;
    }

    public double getCoal() {
        return this.coal;
    }

    public double getPropane() {
        return this.propane;
    }

    public double getWoodenPellets() {
        return this.woodenPellets;
    }

    private double calculateEmission(double unit, double factor) {
        return unit * factor;
    }

    @Override
    public double getCarbonFootprint() {
        double footPrint = 0; // metric tons of CO2e
        footPrint = this.coal + this.electricity + this.heatingOil + this.naturalGas + this.propane
                + this.woodenPellets;
        return footPrint;
    }
}
