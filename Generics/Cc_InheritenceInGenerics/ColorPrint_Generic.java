package Generics.Cc_InheritenceInGenerics;

// Both 'T' should be same. ColorPrint_Generic can have more Generic types('A') which might not present in Print Class.
// 'A' can only be used in ColorPrint_Generic for something else.
public class ColorPrint_Generic<T> extends Print<T> {
}
