package lesson12_recursion.Homework;

public class Task5 {
    public static void main(String[] args) {
        System.out.println(factorial(12));

    }
    static int factorial(int n){
        if(1 < n) {
            return n * factorial(n - 1);
        }
        return 1;
    }
}
