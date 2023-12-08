package Running_SumOf1dArray_MinStartValue;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] arr = {1, 1, 1, 1, 1};
        int[] arr2 = {2,3,5,-5,-1};
        System.out.println(minStartValue3(arr2));
        System.out.println(Arrays.toString(runningSum(arr)));
        System.out.println(Arrays.toString(runningSimSec(arr)));
    }
    public static int minStartValue(int[] nums) {
        int j = 1;
        int m = j;
        for(int i = 0; i < nums.length; ){
            j += nums[i];
            if(j < 1){
                m++;
                j = m;
                i = 0;

            }else {
                i++;
            }
        }

        return m;
        //Time complexity: O(n^2*m)
        //Space complexity: O(1)
    }
    public static int minStartValue2(int[] nums){
        // Let n be the length of the array "nums", m be the absolute value
        // of the lower boundary of the element. In this question we have m = 100.
        int n = nums.length;
        int m = 100;

        // Set left and right boundaries according to left = 1, right = m * n + 1.
        int left = 1;
        int right = m * n + 1;

        while (left < right) {
            // Get the middle index "middle" of the two boundaries, let the start value,
            // be "biddle". The initial step-by-step total "total" equals to middle as well.
            // Use boolean parameter "isValid" to record whether the total
            // is greater than or equal to 1.
            int middle = (left + right)/ 2;
            int total = middle;
            boolean isValid = true;
            // Iterate over the array "nums".
            for (int num : nums) {

                // In each iteration, calculate "total" plus the element "num" in the array.
                total += num;

                // If "total" is less than 1, we shall try a larger start value,
                // we mark "isValid" as "false" and break the current iteration.
                if(total < 1){
                    isValid = false;
                    break;
                }
            }
            // Check if middle is valid, and reduce the search space by half.
            if(isValid){
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        // When the left and right boundaries coincide, we have found
        // the target value, that is the minimum valid startValue.
        return left;
        // Let n be the length of the array nums and m be the absolute value of the lower bound of
        // elements in nums.
        // Time complexity: O(n*log(mn)
        // The lower and upper bounds are 1 and mn+1 respectively. Thus, the number of binary
        // searches we will do is log(mn).
        // For very single search, we need to iterate over the array, which takes O(n) time.
        // Space complexity: O(1)
        // For every search, we just need to calculate the step-by-step total (total), which only
        // requires constant space.
    }
    public static int minStartValue3(int[] nums){
        int min = 100;
        int temp = 0;
        for (int num : nums) {
            temp += num;
            min = Math.min(min, temp);
        }
        if (min < 0){
            return Math.abs(min) + 1;
        } else return Math.min(min, 1);
        // Time complexity: O(n)
        // Space complexity: O(1)

    }
    public static int[] runningSum(int[] nums){
        int [] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i] + result[i -1];

        }

        return result;
        // O(n) time complexity
        // O(1) space complexity
    }
    public static int[] runningSimSec(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
        // O(n) time complexity
        // O(1) space complexity
    }

}

/**
 * 1480. Running Sum of 1d Array
 * Easy
 * 6.8K
 * 307
 * Companies
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 *
 * Return the running sum of nums.
 *
 Input: nums = [1,2,3,4]
 Output: [1,3,6,10]
 Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 */