package Move_Zeroes_283;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums){
        int n = nums.length;
        int numZeroes = 0;
        for (int i = 0; i < n; i++) {
             if(nums[i] == 0){
                 numZeroes++;
             }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(nums[i] != 0){
                ans.add(nums[i]);
            }
        }
        while (numZeroes > 0 ){
            ans.add(0);
            numZeroes--;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = ans.get(i);
        }
        // Time Complexity: O(n) Since we are creating the "ans" list to store results.
        // Spase Complexity: O(n) However, total number of operations are sub-optimal. We can
        // achieve the same result in less number of operations.
    }
    public static void moveZeroes1(int[] nums){
        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
        // Space Complexity: O(1). Only constant is used.
        // Time Complexity: O(n). However, the total number of operations are still sub-optimal. The
        // total operations (array writes) that code does is n (Total number of elements)
    }
    public static  void moveZeroes2(int[] nums){
        for(int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++){
            if(nums[cur] != 0){
                int tmp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt++] = nums[cur];
                nums[cur] = tmp;
            }
        }
        // Spase Complexity: O(1). Only constant space is used.
        // Time Complexity: O(n) .However, the total number of operations are optimal. The total
        // operations (array writes) that code does is Number of non-0 elements. This gives us a much
        // better best-case (when most of the elements are 0) complexity than last solution. However, the
        // worst-case (when all elements are non-0) complexity for both the algorithms is same.
    }


}
