package ExceptionHandling.UncheckedExceptions;

public class IndexOutOfBoundExceptions {
    public static void main(String[] args) {
        // ArrayIndexOutOfBoundsException
//        int[] val = new int[2];
//        System.out.println(val[3]);

        // StringIndexOutOfBoundsException
        String str = "Hello";
        System.out.println(str.charAt(5));
    }
}
