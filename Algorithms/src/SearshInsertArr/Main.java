package SearshInsertArr;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        System.out.println(searchInsert(arr, 2) );

    }
    public static int searchInsert(int[] nums, int target){

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
             int mid = low + (high - low)/2;
            if(target == nums[mid]){
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
