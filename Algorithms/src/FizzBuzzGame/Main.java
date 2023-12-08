package FizzBuzzGame;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


    }


    /**
     * 412. Fizz Buzz
     * Easy
     * 2K
     * 277
     * Companies
     * Given an integer n, return a string array answer (1-indexed) where:
     *
     * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
     * answer[i] == "Fizz" if i is divisible by 3.
     * answer[i] == "Buzz" if i is divisible by 5.
     * answer[i] == i (as a string) if none of the above conditions are true.
     * @param n
     * @return
     */

    public static List<String> fizzBuzz(int n) {
        return new AbstractList<>() {
            @Override
            public String get(int index) {
                return switch (++index % 15) {
                    case 0 -> "FizzBuzz";
                    case 3,6,9,12 -> "Fizz";
                    case 5,10 -> "Buzz";
                    default -> String.valueOf(index);
                };
            }

            @Override
            public int size() {
                return n;
            }
        };
    }
    public static List<String> fizzBuzz2(int n) {
        List<String> answer = new ArrayList<>();

        for(int i = 1; i <=n; i++){
            boolean divideBy3 = i % 3 == 0;
            boolean divideBy5 = i % 5 == 0;

            if(divideBy3 && divideBy5){
                answer.add("FizzBuzz");
            }else if(divideBy3){
                answer.add("Fizz");
            }else if(divideBy5){
                answer.add("Buzz");
            }else{
                answer.add(String.valueOf(i));
            }
        }
        return answer;
        // Time Complexity: O(n)
        // Space Complexity: O(1)
    }

}

