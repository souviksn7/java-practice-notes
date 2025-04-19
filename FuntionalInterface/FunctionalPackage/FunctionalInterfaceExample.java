package FuntionalInterface.FunctionalPackage;

//import java.lang.FunctionalInterface

@FunctionalInterface
public interface FunctionalInterfaceExample {
    void abstractMethod(int a, int b);

    static int staticMethod(int a, int b){
        return a+b;
    }

    default void defaultMethod(String str){
        System.out.println(str + " great");
    }
}

