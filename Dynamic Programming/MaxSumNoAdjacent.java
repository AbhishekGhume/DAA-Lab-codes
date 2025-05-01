// 8. Find the maximum sum of a subsequence with no adjacent elements.
// Given an integer array, find the maximum sum of subsequence where the subsequence contains no element at adjacent positions.
// Please note that the problem specifically targets subsequences that need not be contiguous, i.e., subsequences are not required to occupy consecutive positions within the original sequences.
// For example,
// Input: { 1, 2, 9, 4, 5, 0, 4, 11, 6 }
// Output: The maximum sum is 26
// The maximum sum is formed by subsequence { 1, 9, 5, 11 }


public class MaxSumNoAdjacent {
    public static int findMaxSum(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        
        int include = arr[0];
        int exclude = 0;
        
        for (int i = 1; i < n; i++) {
            int newInclude = exclude + arr[i];
            int newExclude = Math.max(include, exclude);
            
            include = newInclude;
            exclude = newExclude;
        }
        
        return Math.max(include, exclude);
    }
    
    // Method to print the subsequence
    public static void printMaxSumSubsequence(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            System.out.println("Empty array");
            return;
        }
        if (n == 1) {
            System.out.println("Subsequence: " + arr[0]);
            return;
        }
        
        int[] include = new int[n];
        int[] exclude = new int[n];
        
        include[0] = arr[0];
        exclude[0] = 0;
        
        for (int i = 1; i < n; i++) {
            include[i] = exclude[i - 1] + arr[i];
            exclude[i] = Math.max(include[i - 1], exclude[i - 1]);
        }
        
        System.out.println("Maximum sum: " + Math.max(include[n - 1], exclude[n - 1]));
        
        // Backtrack to find the elements
        System.out.print("Subsequence: ");
        int i = n - 1;
        while (i >= 0) {
            if (i == 0) {
                if (include[i] > exclude[i]) {
                    System.out.print(arr[i] + " ");
                }
                break;
            }
            
            if (include[i] > exclude[i]) {
                System.out.print(arr[i] + " ");
                i -= 2;
            } else {
                i--;
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 9, 4, 5, 0, 4, 11, 6};
        
        System.out.println("Maximum sum: " + findMaxSum(arr));
        printMaxSumSubsequence(arr);
        System.out.println("\n\n\n\n.....Code by Abhishek Ghume");
    }
}