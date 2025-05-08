package ExceptionHandling.User_defined_exception;

public class Main {
    public static void main(String[] args) {
        try{
            method();
        } catch (MyCustomException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void method() throws MyCustomException{
        throw new MyCustomException("Some issue arise");
    }
}
