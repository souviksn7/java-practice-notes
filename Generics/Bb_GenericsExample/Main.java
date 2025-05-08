package Generics.Bb_GenericsExample;

public class Main {
    public static void main(String[] args) {
        Print<Integer> printObj = new Print<>();
        printObj.setPrintValue(2);
        Integer printValue = printObj.getPrintValue();
        if(printValue == 2){
            System.out.println(printValue);
        }

        // Raw type object
        // while creating the object, we didn't pass any type as parameterized type. Therefore, internally it passes Object as parameterized type.
        Print printObjRaw = new Print();
        printObjRaw.setPrintValue(34);
        System.out.println(printObjRaw.getPrintValue());
    }
}
