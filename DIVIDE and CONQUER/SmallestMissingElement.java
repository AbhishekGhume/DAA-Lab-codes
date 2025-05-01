// 3. Find the smallest missing element from a sorted array
// Given a sorted array of non-negative distinct integers, find the smallest missing non-negative element in it.
// For example,
// Input: nums[] = [0, 1, 2, 6, 9, 11, 15]
// Output: The smallest missing element is 3
// Input: nums[] = [1, 2, 3, 4, 6, 9, 11, 15]
// Output: The smallest missing element is 0
// Input: nums[] = [0, 1, 2, 3, 4, 5, 6]
// Output: The smallest missing element is 7



public class SmallestMissingElement {
    public static int findSmallestMissing(int[] nums, int left, int right) {
        // Base case: If the first element is not 0, return 0
        if (left > right) return right + 1;
        if (nums[left] != left) return left;
        
        int mid = left + (right - left) / 2;
        
        // If mid element is equal to its index, then the missing element is in the right half
        if (nums[mid] == mid) {
            return findSmallestMissing(nums, mid + 1, right);
        }
        
        // Else the missing element is in the left half
        return findSmallestMissing(nums, left, mid - 1);
    }
    
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 6, 9, 11, 15};
        
        int smallestMissing = findSmallestMissing(nums, 0, nums.length - 1);
        System.out.println("The smallest missing element is " + smallestMissing);
        System.out.println("\n\n\n\n.....Code by Abhishek Ghume");
    }
}