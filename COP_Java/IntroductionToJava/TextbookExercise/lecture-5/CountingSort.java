import java.util.Arrays;

public class CountingSort {
    public void countingSort(int[] array) {
        // Find the maximum value in the array
        int max = Arrays.stream(array).max().getAsInt();
        
        // Find the minimum value in the array (if negative values are considered)
        int min = Arrays.stream(array).min().getAsInt();
        
        // Range of the numbers in the array
        int range = max - min + 1;
        
        // Create count array
        int[] count = new int[range];
        Arrays.fill(count, 0);

        // Count the number of occurrences of each value
        for (int num : array) {
            count[num - min]++;
        }

        // Modify count array by adding the previous counts (accumulating counts)
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Output array to store the sorted result
        int[] output = new int[array.length];
        
        // Build the output array
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }

        // Copy the sorted output array back to the input array
        System.arraycopy(output, 0, array, 0, array.length);
    }

   
}
