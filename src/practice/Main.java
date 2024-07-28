/*an array for sorting all type of positive and negative integers*/

package practice;

public class Main {

    // Method to swap elements in an array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Partition method for sorting negative and positive integers
    static int partition(int[] arr, int start, int end) {
        int pivot = arr[start]; // Choose the first element as the pivot
        int left = start + 1; // Pointer for elements less than or equal to pivot
        int right = end; // Pointer for elements greater than pivot

        while (left <= right) {
            // Move left pointer to the right while it points to a negative number
            while (left <= right && arr[left] <= pivot) left++;
            // Move right pointer to the left while it points to a positive number
            while (left <= right && arr[right] > pivot) right--;

            // Swap the elements at the left and right pointers if they are out of place
            if (left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        // Move pivot to its correct position
        swap(arr, start, right);
        return right; // Return the pivot index
    }

    // QuickSort method for negative numbers (descending order)
    static void quickSortNegative(int[] arr, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(arr, start, end);
            quickSortNegative(arr, start, partitionIndex - 1); // Sort left of partitionIndex
            quickSortNegative(arr, partitionIndex + 1, end); // Sort right of partitionIndex
        }
    }

    // QuickSort method for positive numbers (ascending order)
    static void quickSortPositive(int[] arr, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(arr, start, end);
            quickSortPositive(arr, start, partitionIndex - 1); // Sort left of partitionIndex
            quickSortPositive(arr, partitionIndex + 1, end); // Sort right of partitionIndex
        }
    }

    // Method to print the array
    static void display(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // quick.Main method to test the partition and sorting methods
    public static void main(String[] args) {
        int[] arr = { -13, -20, 7, 8, -4, -13, 11, -5, -13 };

        // Sort negative numbers in descending order
        quickSortNegative(arr, 0, arr.length - 1);

        // Sort positive numbers in ascending order
        quickSortPositive(arr, partition(arr, 0, arr.length - 1) + 1, arr.length - 1);

        // Display the sorted array
        display(arr);
    }
}

