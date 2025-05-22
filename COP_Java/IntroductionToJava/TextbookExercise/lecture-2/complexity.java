import java.util.Arrays;

public class complexity {
    public static void main(String[] args)
    {
        int[] array = {10, 20, 30, 40, 50, 60, 70, 80};

        //constant time complexity O(1)
        int element = array[2]; //takes constant time O(1)
        System.out.println("Element at index 2 = " +element);

        //linear time complexity O(n)
        int sum = 0;
        for (int i = 0; i < array.length; i++) //loop runs n times where n is the length of the array
        {
            sum += array[i];
        }
        System.out.println("Sum of array elements: " +sum);

        //quadratic time complexity O(n^2)
        for (int i = 0; i < array.length; i++) //outter loop runs n times
        {
            for (int j = 0; j < array.length; j++) //inner loop runs n times
            {
                System.out.println("Elemet: " +i +", " +j);
            }
        }

        //logarithmic time complexity O(log n)
        int key = 30;
        int index = Arrays.binarySearch(array,key);
        // This operation has logarithmic time complexity O(log n)
        if (index >= 0) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
	}
}
