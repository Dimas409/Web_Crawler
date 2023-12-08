package stream;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>(List.of(10.0, 5.0, 1.0, 0.25));

//        double sumResult = list.parallelStream()
//                .reduce((a,e) -> a + e).get();
//        System.out.println("sumResult = " + sumResult);

        double divisionResult = list.parallelStream()
                .reduce((a,e) -> a / e).get();
        System.out.println("sumResult = " + divisionResult);
    }
}
