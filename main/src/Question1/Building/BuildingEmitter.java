// This class is a blueprint for the building emitter such as electricity or oil gass
package Question1.Building;

public class BuildingEmitter {
    private double units;
    private EmitterEnum factor;
    private double emitterFootprint;
    private String emitterName;
    private double emitterFactor;

    // Constructor for emitters
    public BuildingEmitter(double units, EmitterEnum factor) {
        setUnits(units); // Initialize the units
        setfactor(factor); // Initialize the factor
        setEmitterName(factor);
        setEmitterRate(factor);
    }

    // Get units
    public double getUnits() {
        return this.units;
    }

    // set units
    public void setUnits(double units) {
        // Validate if the units is above 0
        if (isValid(units))
            this.units = units;
    }

    // Get factor
    public EmitterEnum getfactor() {
        return this.factor;
    }

    // set factor
    public void setfactor(EmitterEnum factor) {
        // Validate if the factor is above 0
        this.factor = factor;
    }

    // set factor name
    private void setEmitterName(EmitterEnum factor) {
        // Validate if the factor is above 0
        this.emitterName = factor.getName();
    }

    // get the emitter
    public String getEmitterName(){
        return this.emitterName;
    }

    // set factor name
    private void setEmitterRate(EmitterEnum factor) {
        // Validate if the factor is above 0
        this.emitterFactor = factor.getValue();
    }

    // get the emitter factor
    public double getEmitterFactor(){
        return this.emitterFactor;
    }

    // get the footprint
    public double getEmitterFootprint(){
        return this.emitterFootprint;
    }

    // Get footprint
    public double getFootprintUnit() {
        return this.calculateFootprint();
    }

    // Calculate the footprint for one
    private double calculateFootprint() {
        return this.emitterFactor * this.units;
    }

    // validate if the userInput is valid
    private boolean isValid(double value) {
        if (value > 0)
            return true;

        return false;
    }

    // create a toString for easy details
}
