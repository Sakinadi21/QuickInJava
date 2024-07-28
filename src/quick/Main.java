package quick;

import java.util.Arrays;

public class Main {
    // Method to swap elements in an array
    static void swap(int[] arr, int i, int j) {
        // Temporary variable to hold the value of arr[i]
        int temp = arr[i];
        // Assign the value of arr[j] to arr[i]
        arr[i] = arr[j];
        // Assign the value of temp (original arr[i]) to arr[j]
        arr[j] = temp;
    }

    // Partition method for QuickSort
    static int partition(int[] arr, int st, int end) {
        // Choose the first element as the pivot
        int pivot = arr[st];
        // Initialize counter for elements less than or equal to pivot
        int cnt = 0;

        // Loop to count elements less than or equal to the pivot
        for (int i = st + 1; i <= end; i++) {
            // If current element is less than or equal to pivot, increment the counter
            if (arr[i] <= pivot) cnt++;
        }

        // Determine the correct position for the pivot element
        int pivotIdx = st + cnt;
        // Move the pivot to its correct position
        swap(arr, st, pivotIdx);

        // Initialize pointers for the partitioning process
        int i = st, j = end;

        // Partition the array around the pivot
        while (i < pivotIdx && j > pivotIdx) {
            // Increment `i` until an element larger than the pivot is found
            while (i < pivotIdx && arr[i] <= pivot) i++;
            // Decrement `j` until an element smaller than or equal to the pivot is found
            while (j > pivotIdx && arr[j] > pivot) j--;

            // If `i` is less than `pivotIdx` and `j` is greater than `pivotIdx`, swap the elements
            if (i < pivotIdx && j > pivotIdx) {
                swap(arr, i, j);
                // Move `i` and `j` to continue the partitioning process
                i++;
                j--;
            }
        }

        // Return the final index of the pivot
        return pivotIdx;
    }

    // quick.Main method to test the partition method
    public static void main(String[] args) {
        // Define a sample array for testing
        int[] arr = {3, 2, 1, 5, 4};
        // Call the partition method and get the pivot index
        int pivotIdx = partition(arr, 0, arr.length - 1);
        // Print the pivot index
        System.out.println("Pivot index: " + pivotIdx);
        // Print the array after partitioning
        System.out.println("Array after partition: " + Arrays.toString(arr));
    }
}


