package Question1.Building;

import java.util.ArrayList;
import Question1.CarbonFootprint;

public class Building implements CarbonFootprint {
    private double carbonFootprintValue; // Carbon footprint value
   private ArrayList<BuildingEmitter> emitters = new ArrayList<>(); // create a list of emitters or sources

    // Collect all emitters as an object
    public void setEmitters(ArrayList<BuildingEmitter> emitters) {
        this.emitters = emitters;
    }

    // get emnitters
    public ArrayList<BuildingEmitter> getEmitters(){
        return this.emitters;
    }


    // Get the carbon footprint
    @Override
    public double getCarbonFootprint() {
       // Calculate the carbon footptint
        var iterator = this.emitters.iterator();
        // Iterate through the emitters and collect the information
        while(iterator.hasNext()){
            this.carbonFootprintValue += iterator.next().getFootprintUnit();
        }
       return this.carbonFootprintValue;
    }

}
