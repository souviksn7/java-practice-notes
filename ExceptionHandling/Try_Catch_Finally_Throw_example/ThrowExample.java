package ExceptionHandling.Try_Catch_Finally_Throw_example;

public class ThrowExample {
    // It's used to throw a new exception or
    // To re-throw the exception
    public static void main(String[] args) throws ClassNotFoundException {
        try{
            method();
        }catch(ClassNotFoundException e){
            throw e;
        }
    }

    public static void method() throws ClassNotFoundException{
        throw new ClassNotFoundException();
    }
}
