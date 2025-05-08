package Refection.Dd_setting_the_value_of_fields;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws Exception {

        Eagle eagleObj = new Eagle();

        Class eagleClass = Eagle.class;

////////////////////////////////// Setting the public field //////////////////////////////////

        Field filed = eagleClass.getDeclaredField("breed");
        filed.set(eagleObj, "human");
        System.out.println("breed: " + eagleObj.breed);
        System.out.println("**************");

////////////////////////////////// Setting the private filed ////////////////////////////////

        Field privateField = eagleClass.getDeclaredField("canSwim");
        privateField.setAccessible(true);
        privateField.set(eagleObj, true);
        if(privateField.getBoolean(eagleObj)){
            System.out.println("Value is set to true");
        }
    }
}
