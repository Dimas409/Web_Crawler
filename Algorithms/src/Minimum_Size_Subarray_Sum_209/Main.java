package Minimum_Size_Subarray_Sum_209;

public class Main {
    public static void main(String[] args) {
        int [] nums = {2,3,1,2,4,3};
        int k = 7;
        System.out.println(minSubArrayLen1(k, nums));
    }
    public static int minSubArrayLen1(int target, int[] nums){
        //Approach #1 Brute Force[Time Limit Exceeded]
        //Intuition
        //Algorithm
        // - Initialize ans = INT_MAX
        // - Iterate the array from left to right using i:
        //  - Iterate the sum of elements from index i to j
        //   - Find the sum of elements from index i to j
        //   - If sum is greater then s:
        //     - Update ans = min(ans, (j - i + 1))
        //     - Start the next ith iteration, since, we got the smallest subarray with sum >= s
        //       starting from the current index.
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k <= j; k++) {
                    sum += nums[k];

                }
                if(sum >= target){
                    ans = Math.min(ans, (j - i + 1));
                    break; // Found the smallest subarray with sum >= target starting with index i,
                    // hence move to next index
                }
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
        // Time complexity: O(n^3)
        // For each element of array, we find all the subarrays starting from that index which is O(n^2)
        // Time complexity to find the sum of each subarray is O(n)
        // Thus, the total time complexity: O(n^2 * n) = O(n^3)
        // Space complexity: O(1) extra space.
    }
    public static int minSubArrayLen2(int target, int[] nums){
        return 0;
    }
}
