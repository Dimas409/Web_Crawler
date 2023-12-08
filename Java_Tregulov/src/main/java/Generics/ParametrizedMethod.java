package Generics;

import java.util.ArrayList;
import java.util.List;

public class ParametrizedMethod {
    public static void main(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<>(List.of(10, 20, 5));

        int a = GenMethod.getSecondElement(al1);
        System.out.println(a);
        ArrayList<String> al2 = new ArrayList<>(List.of("abc", "def", "ghi"));

        String a2 = GenMethod.getSecondElement(al2);
        System.out.println(a2);
    }
}
class GenMethod{
    public static <T> T getSecondElement(ArrayList<T> a1){
        return a1.get(1);
    }
}