package SlidingWindow;

import java.util.Set;

public class Sliding_window {
    public static void main(String[] args) {
        int [] arr = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes2(arr, 2));
        String s = "abciiidef";
        System.out.println(maxVowels(s, 3));

    }
    public static int findLength(int[] nums, int k){
        int left = 0, curr = 0, ans = 0;
        for(int right = 0; right < nums.length; right++){
            curr+=nums[right];
            while (curr > k){
                curr -= nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
        // Time complexity: O(n)
        // Space complexity: O(1)
    }
    public static int findLength2(String str){
        int left = 0, curr = 0, ans = 0;
        for(int right = 0; right < str.length(); right++){
            if(str.charAt(right) == '0'){
                curr++;
            }
            while (curr > 1){
                if(str.charAt(left) == '0'){
                    curr--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
        // Time complexity: O(n)
        // Space complexity: O(1)
    }
    // Medium
    public static int findLength3(int[] nums, int k){
        if(k <= 1){
            return 0;
        }
        int ans = 0, left = 0, curr = 1;
        for (int right = 0; right < nums.length; right++) {
            curr *= nums[right];
            while (curr >= k){
                curr /= nums[left];
                left++;
            }

            ans += right - left + 1;
        }
        return ans;
        // Time complexity: O(n)
        // Space complexity: O(1)
    }
    //Fixed window size
    public static int findBestSubArray(int[] nums, int k){
        int curr = 0;
        for (int i = 0; i < k; i++) {
            curr += nums[i];
        }
        int ans = curr;
        for (int i = k; i < nums.length; i++) {
            curr += nums[i] - nums[i - k];
            ans = Math.max(ans, curr);
        }
        return ans;
        // Time complexity: O(n)
        // Space complexity: O(1)
    }
    public static double findMaxAverage(int[] nums, int k) {
        double curr = 0;
        for(int i = 0; i < k; i++){
            curr+=nums[i];
        }
        double ans = curr/k;
        for(int i = k; i < nums.length; i++){
            curr += nums[i] - nums[i -k];
            ans = Math.max(ans, curr);
        }
        return ans/k;
        // Time complexity: O(n)
        // Space complexity: O(1)
    }
    public static double findMaxAverage2(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum[i] = sum[i - 1] + nums[i];
        double res = sum[k - 1] * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
        }
        return res;
        // Time complexity: O(n)
        // Space complexity: O(n)
    }
    public static int longestOnes(int[] nums, int k) {
        int left = 0, curr = 0, ans = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                curr++;
            }
            while(curr > k){
                if(nums[left] == 0){
                    curr--;
                }
                left++;
            }
            ans = Math.max(ans, right - left +1 );
        }
        return ans;
        // Time complexity: O(n)
        // Space complexity: O(1)
    }
    public static int longestOnes2(int[] nums, int k) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            // If we included a zero in the window we reduce the value of k.
            // Since k is the maximum zeros allowed in a window.
            if (nums[right] == 0) {
                k--;
            }
            // A negative k denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
            if (k < 0) {
                // If the left element to be thrown out is zero we increase k.
                k += 1 - nums[left];
                left++;
            }
            // Time complexity: O(n)
            // Space complexity: O(1)
        }
        return right - left;
    }
    public static int maxVowels(String s, int k){
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u'  );
        int count = 0;
        for (int i = 0; i < k ; i++) {
            count += vowels.contains(s.charAt(i)) ? 1: 0;
        }
        int answer = count;

        for(int i = k; i < s.length(); i++){
            count += vowels.contains(s.charAt(i)) ? 1 : 0;
            count -= vowels.contains(s.charAt(i - k)) ? 1 : 0;
            answer = Math.max(answer, count);
        }
        return answer;
        // Time complexity: O(n)
        // Space complexity: O(1)
    }
}
