package lambda;

import java.util.ArrayList;
import java.util.List;

public class RemoveIf {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>(List.of("Privet", "Poka", "Ok", "Uchim Java", "A imenno lambdas"));
        al.removeIf(element -> element.length() < 5);
        System.out.println(al);
    }
}
