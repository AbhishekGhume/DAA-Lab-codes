// 8. Find the frequency of each element in a sorted array containing duplicates.
// Given a sorted array containing duplicates, efficiently find each element’s frequency without traversing
// the whole array.
// For example,
// Input: [2, 2, 2, 4, 4, 4, 5, 5, 6, 8, 8, 9]
// Output: {2: 3, 4: 3, 5: 2, 6: 1, 8: 2, 9: 1}
// Explanation:
// 2 and 4 occurs thrice
// 5 and 8 occurs twice
// 6 and 9 occurs once

import java.util.LinkedHashMap;
import java.util.Map;

public class ElementFrequency {
    public static Map<Integer, Integer> findFrequencies(int[] arr) {
        Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();
        
        for (int i = 0; i < arr.length;) {
            int element = arr[i];
            
            // Find first occurrence
            int first = findFirstOccurrence(arr, element, 0, arr.length - 1);
            
            // Find last occurrence
            int last = findLastOccurrence(arr, element, 0, arr.length - 1);
            
            // Calculate frequency
            int frequency = last - first + 1;
            
            // Add to map
            frequencyMap.put(element, frequency);
            
            // Move to the next distinct element
            i = last + 1;
        }
        
        return frequencyMap;
    }
    
    private static int findFirstOccurrence(int[] arr, int x, int left, int right) {
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == x) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private static int findLastOccurrence(int[] arr, int x, int left, int right) {
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == x) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 4, 4, 4, 5, 5, 6, 8, 8, 9};
        
        Map<Integer, Integer> frequencies = findFrequencies(arr);
        System.out.println("Element frequencies:");
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            System.out.println("\n\n\n\n.....Code by Abhishek Ghume");
        }
    }
}