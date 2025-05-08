package Generics.Cc_InheritenceInGenerics;

public class Main {
    public static void main(String[] args) {
        ColorPrint_NonGeneric colorPrintObj1 = new ColorPrint_NonGeneric();
        colorPrintObj1.setPrintValue("Color print");

        ColorPrint_Generic<String> colorPrintObj2 = new ColorPrint_Generic<>();
        colorPrintObj2.setPrintValue("Generic color");
    }
}
