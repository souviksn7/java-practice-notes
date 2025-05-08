package Generics.Ff_BoundedGenerics.MultiBoundGEnerics;

public interface Printable {
    void print();
}

class Document {
    String name = "MyDoc";
}

class Report extends Document implements Printable {
    public void print() {
        System.out.println("Printing report: " + name);
    }
}

// Generic class with multi-bound
// <T extends ClassName & Interface1 & Interface2 & so on....>
// Note: You can extend only one class, but implement multiple interfaces.
class Printer<T extends Document & Printable> {
    public void printDocument(T item) {
        item.print(); // can access print() because of Printable
        System.out.println("Document name: " + item.name); // from Document
    }
}

