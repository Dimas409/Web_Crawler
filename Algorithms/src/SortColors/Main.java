package SortColors;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] arr = {2,0,1};
        sortColor(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sortColor(int[]nums){
        int low = 0;
        int high = nums.length -1;
        int temp;
        while (low <= high){
            if(nums[low] > nums[high]){
                temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                high--;
                low++;
            } else if (nums[low] <= nums[high] ) {
                low++;
            }
        }
    }
}
