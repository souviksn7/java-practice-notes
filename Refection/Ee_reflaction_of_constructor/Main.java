package Refection.Ee_reflaction_of_constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws Exception {
        Class eagleClass = Eagle.class;

////////////////////////////////// Singleton patten is broken by reflection ////////////////////////////
// We can change it by adding another check if the instance is already created or not

        //**************** To access private constructor too.********************
        Constructor[] constructors = eagleClass.getDeclaredConstructors();
        for(Constructor constructor: constructors){
            System.out.println("Modifier: " + Modifier.toString(constructor.getModifiers()));

            constructor.setAccessible(true);
            Eagle eagleObj = (Eagle) constructor.newInstance();
            eagleObj.fly();
        }
    }
}
