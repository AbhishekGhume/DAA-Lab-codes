// 1. Longest Common Subsequence Problem
// The Longest Common Subsequence (LCS) problem is finding the longest subsequence present in given two sequences in the same order, i.e., find the longest sequence which can be obtained from the first original sequence by deleting some items and from the second original sequence by deleting other items.
// The problem differs from the problem of finding the longest common substring. Unlike substrings, subsequences are not required to occupy consecutive positions within the original string.
// For example, consider the two following sequences, X and Y:
// X: ABCBDAB
// Y: BDCABA
// The length of the LCS is 4
// LCS are BDAB, BCAB, and BCBA


public class LongestCommonSubsequence {
    public static int lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];
        
        // Build the dp table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[m][n];
    }
    
    // Method to print one of the LCS
    public static String printLCS(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill the dp table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Backtrack to find the LCS
        int index = dp[m][n];
        char[] lcs = new char[index];
        
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs[--index] = X.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        
        return new String(lcs);
    }
    
    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";
        
        System.out.println("Length of LCS: " + lcs(X, Y));
        System.out.println("One of the LCS: " + printLCS(X, Y));
        System.out.println("\n\n\n\n.....Code by Abhishek Ghume");
    }
}