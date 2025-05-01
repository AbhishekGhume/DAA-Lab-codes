// 9. Maximum Subarray Sum using Divide and Conquer Given an integer array, find the maximum sum among all subarrays possible.
// The problem differs from the problem of finding the maximum subsequence sum. Unlike subsequences, subarrays are required to occupy consecutive positions within the original array.
// For example, Input: nums[] = [2, -4, 1, 9, -6, 7, -3]
// Output: The maximum sum of the subarray is 11 (Marked in Green)



public class MaximumSubarraySum {
    public static int maxSubarraySum(int[] nums, int left, int right) {
        // Base case: only one element
        if (left == right) {
            return nums[left];
        }
        
        // Find middle point
        int mid = left + (right - left) / 2;
        
        // Check if maximum subarray sum is in left half
        int leftSum = maxSubarraySum(nums, left, mid);
        
        // Check if maximum subarray sum is in right half
        int rightSum = maxSubarraySum(nums, mid + 1, right);
        
        // Check if maximum subarray sum crosses the middle
        int crossSum = maxCrossingSum(nums, left, mid, right);
        
        // Return maximum of the three
        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }
    
    private static int maxCrossingSum(int[] nums, int left, int mid, int right) {
        // Find maximum sum starting from mid point and going left
        int sum = 0;
        int leftMaxSum = Integer.MIN_VALUE;
        
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftMaxSum = Math.max(leftMaxSum, sum);
        }
        
        // Find maximum sum starting from mid + 1 and going right
        sum = 0;
        int rightMaxSum = Integer.MIN_VALUE;
        
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightMaxSum = Math.max(rightMaxSum, sum);
        }
        
        // Return the combined sum
        return leftMaxSum + rightMaxSum;
    }
    
    public static void main(String[] args) {
        int[] nums = {2, -4, 1, 9, -6, 7, -3};
        
        int maxSum = maxSubarraySum(nums, 0, nums.length - 1);
        System.out.println("The maximum sum of the subarray is " + maxSum);
        System.out.println("\n\n\n\n.....Code by Abhishek Ghume");
    }
}