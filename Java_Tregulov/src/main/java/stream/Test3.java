package stream;

import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        int[] array = {5, 9, 3, 8, 1};
//        Arrays.stream(array)
//                .forEach(a -> System.out.println(a * 2));
        Arrays.stream(array)
                .forEach(Utils::myMethod);
    }
}
class Utils{
    public static void myMethod(int a){
        a+=5;
        System.out.println("Element + " + a);
    }
}