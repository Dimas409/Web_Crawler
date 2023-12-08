package SortedSquares;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = n - 1; i >= 0 ; i--) {
            int square;
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                square = nums[right];
                right--;
            }else {
                square = nums[left];
                left++;
            }
            result[i] = square * square;
        }
        return result;
        //Time Complexity: O(N), where N is the length of A.
        //Space Complexity: O(N) if you take output into account and O(1) otherwise.

    }
    public int[] sortedSquares2(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        for (int i = 0; i < N; ++i)
            ans[i] = A[i] * A[i];

        Arrays.sort(ans);
        return ans;
    }
}
