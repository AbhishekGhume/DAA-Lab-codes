// 5. Find pairs with difference `k` in an array | Constant Space Solution
// Given an unsorted integer array, find all pairs with a given difference k in it without using any extra space.
// For example,
// Input:
// arr = [1, 5, 2, 2, 2, 5, 5, 4]
// k = 3
// Output:
// (2, 5) and (1, 4)

import java.util.Arrays;

public class PairsWithDifference {
    public static void findPairsWithDifference(int[] arr, int k) {
        // Sort the array
        Arrays.sort(arr);
        
        int i = 0, j = 1;
        while (i < arr.length && j < arr.length) {
            if (i != j && arr[j] - arr[i] == k) {
                System.out.println("(" + arr[i] + ", " + arr[j] + ")");
                
                // Skip duplicates
                while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
                    i++;
                }
                while (j + 1 < arr.length && arr[j] == arr[j + 1]) {
                    j++;
                }
                
                i++;
                j++;
            } else if (arr[j] - arr[i] < k) {
                j++;
            } else {
                i++;
            }
            
            // Ensure j is always ahead of i
            if (i == j) {
                j++;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 2, 2, 5, 5, 4};
        int k = 3;
        
        System.out.println("Pairs with difference " + k + ":");
        findPairsWithDifference(arr, k);
        System.out.println("\n\n\n\n.....Code by Abhishek Ghume");
    }
}