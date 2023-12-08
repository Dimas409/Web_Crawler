package lesson12_recursion.Homework;

public class Task3 {
    public static void main(String[] args) {
        int[] numbersArray = {25, 35, 60, 75, 120, 360};

        System.out.println(sumEvenNum(numbersArray, 0));

    }
     static int sumEvenNum(int[] nums, int i) {

        if(i< nums.length){
            if(nums[i] % 2 == 0){
                return nums[i] + sumEvenNum(nums, i + 1);
            }else {
                return sumEvenNum(nums,i +1);
            }

        }

        return 0;
    }
}
