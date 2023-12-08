package Range_Sum_Query_Immutable_303;

import java.util.Arrays;

public class NumArray {
    int[] nums;
    public NumArray(int[] nums){
        this.nums = nums;
    }


    public static void main(String[] args) {
        int[] arr = {-2, 0, 3, - 5, 2, -1};
        NumArray obj = new NumArray(arr);
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));

    }
    public int sumRange(int left, int right){
        int sum = 0;
        while (left <= right){
            sum += nums[left++];
        }
        return sum;
    }

}
