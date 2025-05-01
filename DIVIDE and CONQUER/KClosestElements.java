// 6. Find `k` closest elements to a given value in an array
// Given a sorted integer array, find the k closest elements to target in the array where k and target are given positive integers.
// The target may or may not be present in the input array. If target is less than or equal to the first element in the input array, return first k elements. Similarly, if target is more than or equal to the last element in the input array, return the last k elements. The returned elements should be in the same order as present in the input array.
// For example,
// Input: [10, 12, 15, 17, 18, 20, 25], k = 4, target = 16
// Output: [12, 15, 17, 18]
// Input: [2, 3, 4, 5, 6, 7], k = 3, target = 1
// Output: [2, 3, 4]
// Input: [2, 3, 4, 5, 6, 7], k = 2, target = 8
// Output: [6, 7]



import java.util.ArrayList;
import java.util.List;

public class KClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int target) {
        // Find the closest element to target using binary search
        int left = 0;
        int right = arr.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                left = mid;
                break;
            } else if (arr[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        // Determine which of left or right is closer to target
        if (right < arr.length && Math.abs(arr[left] - target) > Math.abs(arr[right] - target)) {
            left = right;
        }
        
        // Expand around the closest element
        right = left;
        left = left - 1;
        
        while (right - left - 1 < k) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (Math.abs(arr[left] - target) <= Math.abs(arr[right] - target)) {
                left--;
            } else {
                right++;
            }
        }
        
        // Extract the k closest elements
        List<Integer> result = new ArrayList<>();
        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {10, 12, 15, 17, 18, 20, 25};
        int k = 4;
        int target = 16;
        
        List<Integer> result = findClosestElements(arr, k, target);
        System.out.println("The " + k + " closest elements to " + target + " are: " + result);
        System.out.println("\n\n\n\n.....Code by Abhishek Ghume");
    }
}