// 4. 0–1 Knapsack problem
// Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1} Output: 3


public class ZeroOneKnapsack {
    public static int knapsack(int W, int[] weights, int[] profits, int n) {
        int[][] dp = new int[n + 1][W + 1];
        
        // Build the dp table in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(profits[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        return dp[n][W];
    }
    
    public static void main(String[] args) {
        int[] profits = {1, 2, 3};
        int[] weights = {4, 5, 1};
        int W = 4;
        int n = profits.length;
        
        System.out.println("Maximum profit: " + knapsack(W, weights, profits, n));
        System.out.println("\n\n\n\n.....Code by Abhishek Ghume");
    }
}