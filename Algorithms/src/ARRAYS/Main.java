package ARRAYS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int [] nums1 = {2, 0};
        int [] nums2 = {1};
        int m = 1, n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));



    }
    public static int[] buildArray(int[] nums) {
        int[] ans = new int [nums.length];
        int b = 0;
        for(int i = 0; i <= nums.length -1; i++){
            ans[i] = nums[nums[i]];
            b++;
        }
        System.out.println(b);
        return ans;
    }
    public static int[] buildArray2(int[] nums) {
        int mask = 1023; // Decimal value of the binary number '1111111111'
        for(int i = 0; i < nums.length; i++)
            nums[i] |= (nums[nums[i]] & mask) << 10;
        for(int i = 0; i < nums.length; i++)
            nums[i] = nums[i] >> 10;
        return nums;
    }
    public static void duplicateZeros1(int[] arr) {
        List<Integer> listArr = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            listArr.add(arr[i]);
            if(arr[i] == 0){
                listArr.add(0);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = listArr.get(i);
        }
    }
    public static void duplicateZeros(int[] arr){
        int possibleDups = 0;
        int length = arr.length - 1;
        for (int left = 0; left <= length - possibleDups; left++) {
            if(arr[left] == 0){
                if(left == length - possibleDups){
                    arr[length] = 0;
                    length--;
                    break;
                }
                possibleDups++;
            }
        }
        int last = length - possibleDups;
        for(int i = last; i >= 0; i--) {
            if(arr[i] == 0){
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
    }
    public static void merge2 (int[] nums1, int m, int[] nums2, int n){
        int p1 = m - 1, p2 = n - 1;
        for(int i = nums1.length - 1; i >= 0; i--){
            if(p1 >= 0 && p2 >= 0){
                nums1[i] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
            } else if (p1 >= 0) {
                nums1[i] = nums1[p1--];
            } else {
                nums1[i] = nums2[p2--];
            }
        }
        // Time complexity: O(n+m)
        // Space complexity: O(1)
    }
}
