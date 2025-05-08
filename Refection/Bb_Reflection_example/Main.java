package Refection.Bb_Reflection_example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        Class eagleClass = Eagle.class;
        System.out.println(eagleClass.getName());
        System.out.println(Modifier.toString(eagleClass.getModifiers()));

//////////////////////////////////////////// Methods ///////////////////////////////////////////////////////////////////////////

        // print the details of methods
        // This will print the details of Eagle class as well as Object class as Object class is parent of every class

//        Method[] methods = eagleClass.getMethods();
//        for(Method method: methods){
//            System.out.println("Method name " + method.getName());
//            System.out.println("Method return type: " + method.getReturnType());
//            System.out.println("Class name: " + method.getDeclaringClass());
//            System.out.println("************");
//        }

        // This will only print the methods of this class only

        Method[] declaredMethods = eagleClass.getDeclaredMethods();
        for(Method method: declaredMethods){
            System.out.println("Method name " + method.getName());
            System.out.println("Method return type: " + method.getReturnType());
            System.out.println("Class name: " + method.getDeclaringClass());
            System.out.println("************");
        }

////////////////////////////////////////////// Fields //////////////////////////////////////////////////////////////

        Field[] fields = eagleClass.getFields();
        for(Field field: fields){
            System.out.println("Field name: " + field.getName());
            System.out.println("Field type: " + field.getType());
            System.out.println("Modifier: " + Modifier.toString(field.getModifiers()));
            System.out.println("************");
        }

///////////////////////////////////////////// Declared fields ///////////////////////////////////////////////////////

        Field[] declaredFields = eagleClass.getDeclaredFields();
        for(Field field: declaredFields){
            System.out.println("Field name: " + field.getName());
            System.out.println("Field type: " + field.getType());
            System.out.println("Modifier: " + Modifier.toString(field.getModifiers()));
            System.out.println("************");
        }
    }
}
