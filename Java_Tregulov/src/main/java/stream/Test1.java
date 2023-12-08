package stream;

import java.util.*;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(List.of("privet", "kak dela", "ok", "poka"));

//        for (int i = 0; i < list.size(); i++) {
//            list.set(i, String.valueOf(list.get(i).length()));
//        }
       List<Integer> list2 =  list1.stream().map(el -> el.length())
                        .collect(Collectors.toList());
//        System.out.println(list1);
//        System.out.println(list2);
        int[] array = {5, 9, 3, 8, 1};
        int[] array1 = Arrays.stream(array).map(e -> {
            if (e % 3 == 0) {
                e = e / 3;
            }
            return e;
        }).toArray();
//        System.out.println(Arrays.toString(array1));
        Set<String> set = new TreeSet<>(Set.of("privet", "kak dela?", "ok", "poka"));
        Set<Integer> collect = set.stream().map(e -> e.length()).collect(Collectors.toSet());
        List<Integer> collect2 = set.stream().map(e -> e.length()).collect(Collectors.toList());
        System.out.println(collect.getClass());
    }
}
