package ExceptionHandling.CheckedExceptions;

public class Aa_HandlingUsingThrows {
    // Here it's not handled by the way. main method throws it to it's parent to handle.
    public static void main(String[] args) throws ClassNotFoundException{
        method();
    }
    // "throws" tells that this method might throw this exception, so pls caller handle it properly
    public static void method() throws ClassNotFoundException{
        throw new ClassNotFoundException();
    }
}
