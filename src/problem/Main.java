//Give an array of size N containing only 0s ,1s ,and 2s,sort the array in ascending ordee

package problem;
public class Main {

    // Method to swap elements in an array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Method to sort an array of 0s, 1s, and 2s
    static void sort012(int[] a) {
        int lo = 0; // Pointer for the 0s section
        int mid = 0; // Pointer for the 1s section
        int hi = a.length - 1; // Pointer for the 2s section

        // Explore the unknown region
        while (mid <= hi) {
            if (a[mid] == 0) {
                swap(a, mid, lo); // Swap current element with element at lo (which is 0)
                mid++; // Move mid pointer to the right
                lo++; // Move lo pointer to the right
            } else if (a[mid] == 1) {
                mid++; // Element is 1, move mid pointer to the right
            } else { // a[mid] == 2
                swap(a, mid, hi); // Swap current element with element at hi (which is 2)
                hi--; // Move hi pointer to the left
                // No increment of mid because we need to recheck the new value at mid
            }
        }
    }

    public static void main(String[] args) {
        int[] num = {2, 2, 0, 0, 1, 1, 2, 0, 1, 0};
        sort012(num); // Call the sorting method
        for (int n : num) {
            System.out.print(n + " "); // Print sorted array
        }
    }
}
