package ExceptionHandling.CheckedExceptions;

public class Cc_HandleUsingTryCatchInParent {
    public static void main(String[] args) {
        try{
            method();
        }catch(ClassNotFoundException exceptionObj){
            // handle it
        }
    }
    public static void method() throws ClassNotFoundException{
        throw new ClassNotFoundException();
    }
}
