package Generics.Aa_WhyWeNeedGenerics;

public class Main {
    public static void main(String[] args) {
        Print printObj1 = new Print();
        printObj1.setPrintValue(2);
        Object printValue = printObj1.getPrintValue();
        // We cannot use printValue directly, we have to typecast it as it's type is Object.
        if((int)printValue == 2){
            System.out.println(printValue);
        }
    }
}
