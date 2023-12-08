package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Test4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(5, 8, 2, 4, 3) );
        int result = list.stream().reduce((accumulator, element) -> accumulator * element).get();
//        System.out.println(result);
//        5, 8, 2, 4, 3
//        accumulator = 5    40    80     320    {960}
//        element =     8     2     4      3
        int result2 = list.stream().reduce(1, (accumulator, element) -> accumulator * element);
//        System.out.println(result2);
//        5, 8, 2, 4, 3
//        accumulator =  1     5     40     80     320    {960}
//        element =      5     8     2      4       3

        List<String> list3 = new ArrayList<>(List.of("privet", "kak dela?", "OK", "poka"));

        String result3 = list3.stream()
                .reduce((a, e) -> a + " " + e).get();
        System.out.println(result3);


//        List<Integer> list100 = new ArrayList<>();
//        Optional<Integer> o = list100.stream()
//                .reduce((accumulator, element) -> accumulator * element);
//        o.ifPresent(System.out::println);

    }
}
