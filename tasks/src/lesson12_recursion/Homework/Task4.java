package lesson12_recursion.Homework;

public class Task4 {
    public static void main(String[] args) {
        int[] numbersArray = {25, 35, 60, 75, 120, 360};
        System.out.println(maxNumber(numbersArray, 0));
    }
    static int maxNumber(int[] arr, int i) {
        if(i < arr.length-1) {
            return Math.max(arr[i], maxNumber(arr, i+1));
        }
        return arr[i];
    }
}
