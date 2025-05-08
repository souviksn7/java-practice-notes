package ExceptionHandling.User_defined_exception;

public class MyCustomException extends Exception{
    public MyCustomException(String message){
        super(message);
    }
}
