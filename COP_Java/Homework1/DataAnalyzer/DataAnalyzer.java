/* This program 
 * a. reads a sequence of numbers from the terminal 
 * b. saves them to a file with a name given from the terminal
 * c. calculates the max, min, average, saves them to that file, and displays calculation.
 */
package DataAnalyzer;

import java.util.LinkedList;

public class DataAnalyzer 
{
    //create a class attribute
    private LinkedList<Integer> numbers;

    //Constructor that stores the list of numbers
    public DataAnalyzer(LinkedList<Integer> numList)
    {
        numbers = numList;
    }    

    //method for computing the minimum
    public int min()
    {
        //initialize min to maximum constant integer class
        int min = Integer.MAX_VALUE;

        //for loop coninues as long as i is less than numbers list size
        for (int i = 0; i < numbers.size(); i++)
        {
            //if numbers.get(i) is less than min, set min to numbers.get(i)
            if (numbers.get(i) < min)
            {
                //updates the value of min to the current element from the numbers list
                min = numbers.get(i);
            }
        }
        return min;
    }

    // method for computing the maximum
    public int max() 
    {
        //initialize max to minimum constant integer class
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.size(); i++) 
        {
            if (numbers.get(i) > max) 
            {
                //updates the value of max to the current element from the numbers list
                max = numbers.get(i);
            }
        }
        return max;
    }

    //method for computing the average
    public double average()
    {
        // set sum to 0
        int sum = 0;
    
        for (int i = 0; i < numbers.size(); i++)
        {
            // sum = sum + numbers.get(i)
            sum += numbers.get(i);
        }
        
        double avg = (double) sum / numbers.size();
        return avg;
    }
}
