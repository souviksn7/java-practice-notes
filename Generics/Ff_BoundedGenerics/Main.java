package Generics.Ff_BoundedGenerics;

public class Main {
    public static void main(String[] args) {
        PrintUpperBound<Integer> printObj = new PrintUpperBound<>();
        printObj.setPrintValue(2);
        Integer printValue = printObj.getPrintValue();
        if(printValue == 2){
            System.out.println(printValue);
        }
    }
}
