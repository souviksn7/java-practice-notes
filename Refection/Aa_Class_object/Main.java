package Refection.Aa_Class_object;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        // get the object of Class for getting the metadata information of bird class.

        // Using forName() method
        Class bird1 = Class.forName("Bird");

        // using .class
        Class bird2 = Bird.class;

        // using getClass() method
        Bird birdObj = new Bird();
        Class bird3 = birdObj.getClass();
    }
}
