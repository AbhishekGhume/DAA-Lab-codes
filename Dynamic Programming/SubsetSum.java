// 5. Subset Sum Problem – Dynamic Programming Solution
// Given a set of positive integers and an integer k, check if there is any non-empty subset that sums to k.
// For example,
// Input:
// A = { 7, 3, 2, 5, 8 }
// k = 14
// Output: Subset with the given sum exists
// Subset { 7, 2, 5 } sums to 14



public class SubsetSum {
    public static boolean isSubsetSumPossible(int[] set, int sum) {
        int n = set.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        
        // If sum is 0, answer is true
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        // If sum is not 0 and set is empty, answer is false
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }
        
        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < set[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
                }
            }
        }
        
        return dp[n][sum];
    }
    
    // Method to print one of the subsets that sum to the target
    public static void printSubset(int[] set, int sum) {
        int n = set.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        
        // Fill the dp table
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < set[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
                }
            }
        }
        
        // No subset with given sum
        if (!dp[n][sum]) {
            System.out.println("No subset with the given sum exists");
            return;
        }
        
        // Backtrack to find the subset
        System.out.print("Subset with sum " + sum + ": ");
        int i = n, j = sum;
        
        while (i > 0 && j > 0) {
            // If the current element is not included in the subset
            if (dp[i - 1][j]) {
                i--;
            } else {
                System.out.print(set[i - 1] + " ");
                j -= set[i - 1];
                i--;
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] set = {7, 3, 2, 5, 8};
        int sum = 14;
        
        if (isSubsetSumPossible(set, sum)) {
            System.out.println("Subset with the given sum exists");
            printSubset(set, sum);
        } else {
            System.out.println("No subset with the given sum exists");
            System.out.println("\n\n\n\n.....Code by Abhishek Ghume");
        }
    }
}