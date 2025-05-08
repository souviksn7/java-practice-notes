package Generics.Ff_BoundedGenerics;

// It is used to restrict what all objects we can pass at this type parameter
public class PrintUpperBound<T extends Number>{
    private T value;
    public T getPrintValue(){
        return value;
    }
    public void setPrintValue(T value){
        this.value = value;
    }
}
