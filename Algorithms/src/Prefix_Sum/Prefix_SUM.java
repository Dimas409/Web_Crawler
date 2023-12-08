package Prefix_Sum;

import java.util.Arrays;

public class Prefix_SUM {
    public static void main(String[] args) {
        int[] nums = {1, 6, 3, 2, 7, 2};
        int [][] queries = {{0, 3},{2, 5}, {2, 4}};
        int limit = 13;
        int [] gain = {44,32,-9,52,23,-50,50,33,-84,47,-14,84,36,-62,37,81,-36,-85,-39,67,-63,64,-47,95,91,-40,65,67,92,-28,97,100,81};
        System.out.println(Arrays.toString(answerQueries(nums, queries, limit)));
        int [] n = {4, 0};
        System.out.println(findMiddleIndex(n));


    }
    public static int findMiddleIndex(int[] nums){
        /**
         * Approach #1: Prefix Sum [Accepted]
         * Intuition and Algorithm
         *
         * We need to quickly compute the sum of values to the left and the right of every index.
         *
         * Let's say we knew S as the sum of the numbers, and we are at index i. If we knew the sum
         * of numbers leftsum that are to the left of index i, then the other sum to the right of the
         * index would just be S - nums[i] - leftsum.
         *
         * As such, we only need to know about leftsum to check whether an index is a pivot index in
         * constant time. Let's do that: as we iterate through candidate indexes i, we will maintain the
         * correct value of leftsum.
         */
        int sum = 0, leftSum = 0;
        for(int num : nums) sum += num;
        for (int i = 0; i < nums.length; ++i) {
            if(leftSum == sum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
       return - 1;
        /**
         * Time Complexity: O(n), where N is the length of nums.
         * Space Complexity: O(1), the space used by leftSum and s.
         */
    }
    public static boolean[] answerQueries(int[] nums, int[][] queries, int limit) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            int curr = prefix[y] - prefix[x] + nums[x];
            ans[i] = curr < limit;
        }

        return ans;
    }
    public static int waysToSplitArray(int[] nums){
        int n = nums.length;

        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i]= nums[i] + prefix[i - 1];
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            long leftSection = prefix[i];
            long rightSection = prefix[n - 1] - prefix[i];
            if(leftSection >= rightSection){
                ans++;
            }
        }
        return ans;
    }
    public static int waysToSplitArray2(int[] nums){
        int ans = 0;
        long leftSection = 0;
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            leftSection +=nums[i];
            long rightSection = total - leftSection;
            if(leftSection >= rightSection){
                ans++;
            }
        }
        return ans;
        //Time complexity: ?
        // Space complexity: O(1)
    }

 // 1732. Find the Highest Altitude

    /**
     * There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes.
     * The biker starts his trip on point 0 with altitude equal 0.
     *
     * You are given an integer array gain of length n where gain[i] is the net gain in altitude between points
     * i and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
     * @param gain
     * @return
     */
     public static int largestAltitude(int[] gain) {
//         int[] prefix = new int[gain.length + 1];
//         prefix[0] = 0;
//         int ans = 0;
//         for(int i = 0, j = 1; i < gain.length; i++, j++){
//             prefix[j] = gain[i] + prefix[j - 1];
//         }
//         for (int j : prefix) {
//             ans = Math.max(ans, j);
//         }
//         return ans;
         int sum = 0;
         int max = 0;
         for(int i = 0; i < gain.length; i++){
             sum+=gain[i];
             if(sum > max){
                 max = sum;
             }
         }
         return max;
         // Time complexity: O(n)
         // Spase complexity: O(n)
     }
}
