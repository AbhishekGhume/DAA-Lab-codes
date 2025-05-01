// 7. Create optimal cost to construct a binary search tree If the keys are 10, 20, 30, 40, 50, 60, 70 Answer: 26 is the minimum cost


public class OptimalBST {
    public static int optimalBSTCost(int[] keys, int[] freq, int n) {
        int[][] dp = new int[n][n];
        
        // For single keys, the cost is the frequency of the key
        for (int i = 0; i < n; i++) {
            dp[i][i] = freq[i];
        }
        
        // For chains of length 2 to n
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;
                
                // Try each key as root and find the minimum cost
                for (int r = i; r <= j; r++) {
                    // Cost of the subtree with keys[r] as the root
                    int cost = (r > i) ? dp[i][r - 1] : 0;
                    cost += (r < j) ? dp[r + 1][j] : 0;
                    
                    // Add the sum of all frequencies
                    int sum = 0;
                    for (int k = i; k <= j; k++) {
                        sum += freq[k];
                    }
                    cost += sum;
                    
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }
        
        return dp[0][n - 1];
    }
    
    public static void main(String[] args) {
        int[] keys = {10, 20, 30, 40, 50, 60, 70};
        int[] freq = {4, 2, 6, 3, 1, 5, 7};
        
        System.out.println("Minimum cost of optimal BST: " + optimalBSTCost(keys, freq, keys.length));
        System.out.println("\n\n\n\n.....Code by Abhishek Ghume");
    }
}