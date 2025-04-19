package FuntionalInterface.FunctionalPackage;

public class Demo implements FunctionalInterfaceExample {
    @Override
    public void abstractMethod(int a, int b) {
        System.out.println("In demo");
    }

    @Override
    public void defaultMethod(String str) {
        FunctionalInterfaceExample.super.defaultMethod(str);
    }
}
