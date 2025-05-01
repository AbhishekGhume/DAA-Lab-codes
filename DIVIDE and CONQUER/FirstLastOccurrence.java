// 2. Find the first or last occurrence of a given number in a sorted array.
// Given a sorted integer array, find the index of a given number’s first or last occurrence. If the element is not present in the array, report that as well.
// For example,
// Input:
// nums = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9]
// target = 5
// Output:
// The first occurrence of element 5 is located at index 1
// The last occurrence of element 5 is located at index 3
// Input:
// nums = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9]
// target = 4
// Output:
// Element not found in the array



public class FirstLastOccurrence {
    public static int findFirstOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching left
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    public static int findLastOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching right
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
        int target = 5;
        
        int firstOccurrence = findFirstOccurrence(nums, target);
        int lastOccurrence = findLastOccurrence(nums, target);
        
        if (firstOccurrence != -1) {
            System.out.println("The first occurrence of element " + target + " is located at index " + firstOccurrence);
            System.out.println("The last occurrence of element " + target + " is located at index " + lastOccurrence);
        } else {
            System.out.println("Element not found in the array");
        }
        System.out.println("\n\n\n\n.....Code by Abhishek Ghume");
    }
}