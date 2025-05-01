// 6. Rod Cutting Problem
// Given a rod of length n and a list of rod prices of length i, where 1 <= i <= n, find the optimal way to cut the rod into smaller rods to maximize profit.
// For example, consider the following rod lengths and values:
// Input:
// length[] = [1, 2, 3, 4, 5, 6, 7, 8]
// price[] = [1, 5, 8, 9, 10, 17, 17, 20]
// Rod length: 4
// Best: Cut the rod into two pieces of length 2 each to gain revenue of 5 + 5 = 10



public class RodCutting {
    public static int rodCutting(int[] prices, int n) {
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            int maxValue = Integer.MIN_VALUE;
            
            for (int j = 0; j < i; j++) {
                maxValue = Math.max(maxValue, prices[j] + dp[i - j - 1]);
            }
            
            dp[i] = maxValue;
        }
        
        return dp[n];
    }
    
    // Method to print the optimal cuts
    public static void printOptimalCuts(int[] prices, int n) {
        int[] dp = new int[n + 1];
        int[] cuts = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            int maxValue = Integer.MIN_VALUE;
            
            for (int j = 0; j < i; j++) {
                int value = prices[j] + dp[i - j - 1];
                if (value > maxValue) {
                    maxValue = value;
                    cuts[i] = j + 1;
                }
            }
            
            dp[i] = maxValue;
        }
        
        System.out.println("Maximum revenue: " + dp[n]);
        System.out.print("Optimal cuts: ");
        
        while (n > 0) {
            System.out.print(cuts[n] + " ");
            n -= cuts[n];
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = 4;
        
        System.out.println("Maximum revenue: " + rodCutting(prices, rodLength));
        printOptimalCuts(prices, rodLength);
        System.out.println("\n\n\n\n.....Code by Abhishek Ghume");
    }
}