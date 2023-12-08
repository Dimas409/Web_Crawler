package Remove_Element_from_Array;


public class Main {
    public static void main(String[] args) {
        int [] arr = {0,1,2,2,3,0,4,2};
//        int i = removeElement(arr, 2);
////        System.out.println(i);
        int[] arr2 = {0,0,1,1,1,2,2,3,3,4};
        int j = removeDuplicates(arr2);
        System.out.println(j);
        int[] arr3 = {-1,0,3,5,9,12};
        System.out.println(search(arr3, 9));
        
    }
    public static int removeElement(int[] nums, int val){
        int i = 0;
        for (int j = 0; j < nums.length; j++){
            if(nums[j] != val){
//                int temp = nums[i];
                nums[i] = nums[j];
//                nums[j] = temp;
                i++;
            }
        }
        return i;
    }
    public static int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 0; i < nums.length - 1; i++){
            if(nums[i] < nums[i + 1]){
                nums[index] = nums[i + 1];
                index++;
            }
        }
        return index;
    }
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(mid < target){
                left = mid + 1;
            } else{
                right = mid - 1;
            }

        }
        return - 1;
    }
}
