// 7. Longest Common Prefix (LCP) Problem
// Write an efficient algorithm to find the longest common prefix (LCP) between a given set of strings.
// For example,
// Input: technique, technician, technology, technical
// Output: The longest common prefix is techn
// Input: techie delight, tech, techie, technology, technical
// Output: The longest common prefix is tech



public class LongestCommonPrefix {
    public static String findLCP(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }
    
    private static String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        
        int mid = left + (right - left) / 2;
        String lcpLeft = longestCommonPrefix(strs, left, mid);
        String lcpRight = longestCommonPrefix(strs, mid + 1, right);
        
        return commonPrefix(lcpLeft, lcpRight);
    }
    
    private static String commonPrefix(String left, String right) {
        int minLength = Math.min(left.length(), right.length());
        
        for (int i = 0; i < minLength; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        
        return left.substring(0, minLength);
    }
    
    public static void main(String[] args) {
        String[] strings = {"technique", "technician", "technology", "technical"};
        
        String lcp = findLCP(strings);
        System.out.println("The longest common prefix is " + lcp);
        System.out.println("\n\n\n\n.....Code by Abhishek Ghume");
    }
}