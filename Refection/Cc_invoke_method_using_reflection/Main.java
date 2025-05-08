package Refection.Cc_invoke_method_using_reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] str) throws Exception{
        Class eagleClass = Eagle.class;
        Object eagleObj = eagleClass.newInstance();

        Method flyMethod = eagleClass.getMethod("fly", int.class, boolean.class, String.class);
        // Here If I pass 3 as an int, it will compile but will fail atr runtime as refection works at runtime.
        flyMethod.invoke(eagleObj, 1, true, "3");
    }
}
