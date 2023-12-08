package lambda;

import java.util.ArrayList;
import java.util.List;

public class ForEach {
    public static void main(String[] args) {
        List<String > list = List.of("privet", "kak dela?", "normalno", "poka");
        list.forEach(str -> System.out.println(str));
        List<Integer> list2 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        list2.forEach(el ->{
            System.out.println(el);
            el *=2;
            System.out.println(el);
        });

    }
}
