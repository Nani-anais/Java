package Homework0;
import java.util.Scanner;

public class MethodsParameters 
{
    static void myMethod(String xname, String xlastname, int xID)
    {
        System.out.println("Hello, " + xname + " " + xlastname);
        System.out.println("Your ID is: " + xID);
    }

    public static void main(String[] args)
    {
        //to declare a scanner object called: scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name, and last name: ");
        
        //to read the input from the user
        //String variable = scanner . reads the next line
        //append the next line in the scanner object
        String xname = scanner.nextLine();
        String xlastname = scanner.nextLine();

        System.out.println("Enter your ID code: ");
        //append the next integer in the scanner object
        int xID = scanner.nextInt();

        scanner.close();

        //call the method passing the scanner values 
        myMethod(xname, xlastname, xID);
    }
}
