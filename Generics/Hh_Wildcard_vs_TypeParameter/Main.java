package Generics.Hh_Wildcard_vs_TypeParameter;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> wildCardIntegerSourceList = new ArrayList<>();
        List<Float> wildCardFloatDestinationList = new ArrayList<>();

        Print printObj = new Print();

        printObj.computeList1(wildCardIntegerSourceList, wildCardFloatDestinationList);

        // this is wrong
//        printObj.computeList2(wildCardIntegerSourceList, wildCardFloatDestinationList);
    }
}
