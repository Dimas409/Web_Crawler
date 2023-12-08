package stream;

import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) {
        int[] array = {3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18};
//        array = Arrays.stream(array).sorted().toArray();
//        System.out.println(Arrays.toString(array));
        int reduce = Arrays.stream(array)
                .filter(e -> e % 2 != 0)
                .map(e -> {
                    if (e % 3 == 0) {
                        e /= 3;
                    }
                    return e;
                })
                .reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}
