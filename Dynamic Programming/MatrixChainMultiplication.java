// 3. Matrix Chain Multiplication using Dynamic Programming (10x100),(100x5),(5x500) minimum cost is 5000


public class MatrixChainMultiplication {
    public static int matrixChainOrder(int[] dimensions) {
        int n = dimensions.length - 1;
        int[][] dp = new int[n][n];
        
        // l is the chain length
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions[i] * dimensions[k + 1] * dimensions[j + 1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        
        return dp[0][n - 1];
    }
    
    public static void main(String[] args) {
        // Example: (10x100) * (100x5) * (5x500)
        int[] dimensions = {10, 100, 5, 500};
        
        System.out.println("Minimum cost of matrix chain multiplication: " + matrixChainOrder(dimensions));
        System.out.println("\n\n\n\n.....Code by Abhishek Ghume");
    }
}