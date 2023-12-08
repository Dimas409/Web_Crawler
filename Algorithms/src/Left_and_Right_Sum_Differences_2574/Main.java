package Left_and_Right_Sum_Differences_2574;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] arr = {10,4,8,3};
        System.out.println(Arrays.toString(leftRightDifference(arr)));

    }
    public static int[] leftRightDifference(int[] nums){
        int[] leftPrefix = new int[nums.length];
        int[] rightPrefix = new int[nums.length];
        int sum = 0;
        rightPrefix[nums.length-1] = sum;
        for (int i = 0; i < nums.length; i++) {
            leftPrefix[i] = sum;
            sum += nums[i];
        }
        sum = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            rightPrefix[i] = Math.abs(leftPrefix[i] - sum);
            sum += nums[i];
        }
        return rightPrefix;
        // Time complexity: O(n)
        // Space complexity: O(n)
    }
}
