// 1. Inversion count of an array
// Given an array, find the total number of inversions of it. If (i < j) and (A[i] > A[j]), then pair (i, j) is called an inversion of an array A. We need to count all such pairs in the array.
// For example,
// Input: A[] = [1, 9, 6, 4, 5]
// Output: The inversion count is 5
// There are 5 inversions in the array: (9, 6), (9, 4), (9, 5), (6, 4), (6, 5)


public class InversionCount {
    public static int countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }
    
    private static int mergeSort(int[] arr, int left, int right) {
        int inversions = 0;
        
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            // Count inversions in left subarray
            inversions += mergeSort(arr, left, mid);
            
            // Count inversions in right subarray
            inversions += mergeSort(arr, mid + 1, right);
            
            // Count inversions during merge
            inversions += merge(arr, left, mid, right);
        }
        
        return inversions;
    }
    
    private static int merge(int[] arr, int left, int mid, int right) {
        int inversions = 0;
        
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }
        
        // Merge the temp arrays
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                // If leftArr[i] > rightArr[j], then all elements 
                // in leftArr[i..n1-1] will form an inversion with rightArr[j]
                arr[k++] = rightArr[j++];
                inversions += (n1 - i);
            }
        }
        
        // Copy remaining elements
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
        
        return inversions;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 9, 6, 4, 5};
        int inversions = countInversions(arr);
        
        System.out.println("The inversion count is " + inversions);
        System.out.println("\n\n\n\n.....Code by Abhishek Ghume");
    }
}