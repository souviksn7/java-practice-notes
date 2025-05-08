package Generics.Gg_WildcardExample;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Bus());
        vehicleList.add(new Car());

        List<Bus> busList = new ArrayList<>();

        PrintUpperBound printObj = new PrintUpperBound();
        printObj.setPrintValues(vehicleList);
        printObj.setPrintValues(busList);

        List<Object> objectList = new ArrayList<>();
        PrintLowerBound printObj1 = new PrintLowerBound();
        printObj1.setPrintValues(objectList);

        // But cannot do this
//        printObj.setPrintValues(objectList);
    }
}
