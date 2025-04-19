package FuntionalInterface.FunctionalPackage;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] str){
        FunctionalInterfaceExample functionalInterfaceExample = (int a, int b)->{
            System.out.println("sum it a+b = "+ (a+b));
        };
        functionalInterfaceExample.abstractMethod(9, 7);

        Consumer<String> consumerInterfaceClass = (String string)->{
            System.out.println(string);
        };
        consumerInterfaceClass.accept("hello");

        Supplier<Integer> supplierInterfaceClass = ()->{
            return 10;
        };
        System.out.println(supplierInterfaceClass.get());

        Function<Integer, String> functionInterfaceClass = (Integer a)->{
            return ("I got you " + a);
        };
        System.out.println(functionInterfaceClass.apply(90));

        Predicate<Integer> predicateInterfaceClass = (Integer a)->{
            if(a>10)
                return true;
            else
                return false;
        };
        System.out.println(predicateInterfaceClass.test(80));

        Function<Integer, String> func = (Integer a) -> {
            return ("I got you " + a);
        };
        func.apply(10);

        List<Integer> list = Arrays.asList(2,5,7,1,4);
        Stream stream = list.stream().peek((a)-> System.out.println(a));
    }
}
