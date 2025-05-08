package ExceptionHandling.CheckedExceptions;

public class Bb_HandlingUsingTryCatchInMethod {
    public static void main(String[] str){
        method();
    }
    public static void method() {
        try{
            throw new ClassNotFoundException();
        }catch(ClassNotFoundException exceptionObject){
            // handle this exception scenario like logging
            exceptionObject.printStackTrace();
        }
    }
}
