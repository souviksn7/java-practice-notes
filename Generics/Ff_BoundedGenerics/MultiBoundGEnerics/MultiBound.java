package Generics.Ff_BoundedGenerics.MultiBoundGEnerics;

public class MultiBound {
    public static void main(String[] args) {
        Printer<Report> printer = new Printer<>();
        printer.printDocument(new Report());
    }
}
