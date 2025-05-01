// 2. Longest Common Substring Problem
// The longest common substring problem is the problem of finding the longest string (or strings) that is a substring (or are substrings) of two strings.
// The problem differs from the problem of finding the Longest Common Subsequence (LCS). Unlike subsequences, substrings are required to occupy consecutive positions within the original string.
// For example, the longest common substring of strings ABABC, BABCA is the string BABChaving length 4. Other common substrings are ABC, A, AB, B, BA, BC, and C.


public class LongestCommonSubstring {
    public static int lcSubstring(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];
        int result = 0;
        
        // Build the dp table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return result;
    }
    
    // Method to print the longest common substring
    public static String printLCSubstring(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];
        
        int maxLength = 0;
        int endIndex = 0;
        
        // Build the dp table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i - 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        // Extract the substring from X
        return X.substring(endIndex - maxLength + 1, endIndex + 1);
    }
    
    public static void main(String[] args) {
        String X = "ABABC";
        String Y = "BABCA";
        
        System.out.println("Length of longest common substring: " + lcSubstring(X, Y));
        System.out.println("Longest common substring: " + printLCSubstring(X, Y));
        System.out.println("\n\n\n\n.....Code by Abhishek Ghume");
    }
}