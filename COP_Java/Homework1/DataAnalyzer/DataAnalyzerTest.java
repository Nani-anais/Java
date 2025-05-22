/* this program reads the numbers, builds the number list, creates the 
* DataAnalyzer object, and displays the min, max, and average using the 
* DataAnalyzer object's methods.
 */
package DataAnalyzer;
import java.util.Scanner;
import java.util.LinkedList;
import java.io.File; //File class
import java.io.FileWriter; //
import java.io.IOException;

public class DataAnalyzerTest 
{
    public static void main(String[] args)
    {
        //create a scanner object
        Scanner input = new Scanner(System.in);

        //create a linked list object
        LinkedList<Integer> numList = new LinkedList<>();

        //prompt the user to enter a file name
        System.out.println("Enter the file name: ");
        String fileName = input.nextLine();

        //prompt the user to enter the numbers
        System.out.println("Enter the numbers seperated by spaces and end list with key word 'end': ");

        //read the numbers from the terminal
        while (input.hasNextInt())
        {
            //if the input has more integers add to numList
            if (input.hasNextInt())
            {
                //adds next input to numList
                numList.add(input.nextInt());
            }
            //if the input is 'end' break the loop
            else 
            {
                //initialize end_String to the next input 
                String end_String = input.next();
                //if end_String is equal to 'end' break the loop
                if (end_String.equals("end"))
                {
                    break;
                }
                else
                {
                    System.out.println("Please enter a valid number.");
                }
            }
        }

        //validate the inputs
        if (fileName.isEmpty() || numList.isEmpty())
        {
            System.out.println("Please enter a valid file name and at least two numbers.");
            input.close(); // Close the scanner
            return;
        }
        
        //create a DataAnalyzer object
        DataAnalyzer data = new DataAnalyzer(numList);

        //call the methods in DataAnalyzer to calculate the data
        int min = data.min();
        int max = data.max();
        double avg = data.average();

        //write the claculated data to the file
        //writing in a try block to catch any exceptions
        try
        {
            //create file object
            File myfile = new File(fileName);

            //create the file 
            if (myfile.createNewFile()) 
            {
                //prints the name of file
                System.out.println("File created: " + myfile.getName());
            } 
            else 
            {
                System.out.println("File already exists.");
            }

            //create a file writer object to write in file
            try (FileWriter writer = new FileWriter(myfile)) 
            {
                //write the data to the file
                writer.write("Numbers: " + numList.toString() + "\n");
                writer.write("Minimum: " + min + "\n");
                writer.write("Maximum: " + max + "\n");
                writer.write("Average: " + avg + "\n");
                System.out.println("Successfully wrote to the file.");
            }
        } 

        catch (IOException exception) 
        {
            System.out.println("An error occurred while writing to the file." + exception.getMessage());
        } 
        finally 
        {
            // Close the scanner
            input.close();
        }
    }
    
}
