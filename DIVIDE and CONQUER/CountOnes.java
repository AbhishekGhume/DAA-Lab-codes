// 4. Find the number of 1’s in a sorted binary array
// Given a sorted binary array, efficiently count the total number of 1’s in it. For example,
// Input: nums[] = [0, 0, 0, 0, 1, 1, 1]
// Output: The total number of 1’s present is 3
// Input: nums[] = [0, 0, 1, 1, 1, 1, 1]
// Output: The total number of 1’s present is 5


public class CountOnes {
    public static int countOnes(int[] nums) {
        int n = nums.length;
        
        // If array is empty or last element is 0, return 0
        if (n == 0 || nums[n - 1] == 0) {
            return 0;
        }
        
        // If first element is 1, all elements are 1
        if (nums[0] == 1) {
            return n;
        }
        
        // Find the index of first 1
        return n - findFirstOne(nums, 0, n - 1);
    }
    
    private static int findFirstOne(int[] nums, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == 1 && (mid == 0 || nums[mid - 1] == 0)) {
                return mid;
            } else if (nums[mid] == 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; // Should not reach here if array has at least one 1
    }
    
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 1, 1, 1};
        
        System.out.println("The total number of 1's present is " + countOnes(nums));
        System.out.println("\n\n\n\n.....Code by Abhishek Ghume");
    }
}