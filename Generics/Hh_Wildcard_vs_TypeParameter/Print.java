package Generics.Hh_Wildcard_vs_TypeParameter;

import java.util.List;

public class Print {
    public void computeList1(List<? extends Number> source, List<? extends Number> destination){
    }

    public <T extends Number> void computeList2(List<T> source, List<T> destination){
    }
}
