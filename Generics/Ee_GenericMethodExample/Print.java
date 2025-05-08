package Generics.Ee_GenericMethodExample;

public class Print {
    // Putting the generic type on method not on class.
    public <T> void printValue(T value){
        System.out.println(value);
    }
}
