import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        // create an array that will hold the objects of the classes
        ArrayList<CarbonFootprint> offsets = new ArrayList<CarbonFootprint>();

        offsets.add(new Car("Vitz", 8, 1500,2 ));

       System.out.print(((Car) offsets.get(0)).getFuelType());
    }

    public void print(CarbonFootprint myobject){
        if(myobject instanceof Car){
            // print for cars
            System.out.print("Hello, car");
        }
        else if(myobject instanceof Building){
            // print for building

        }
        else if(myobject instanceof Bicycle){
            // print for bicycle

        }
    }
}
