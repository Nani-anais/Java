/* A java program that calculates and displays the Fibonacci series
 * defined by the recursive fromula F(n) = F(n-1) + F(n-2)
 *F(0) and F(1) are given on the command line
*/

import java.util.InputMismatchException; //need this import to use new exception handeling
import java.util.Scanner; //need this import to use I/O stream similar to C++

public class Fib
{
    //initialize instance variables that store F(0) and F(1)
    private int f0;
    private int f1;

    //constructor
    public Fib(int f0_prev, int f1_next)
    {
        //ensuring the class has instance variables for F(0) and F(1)
        this.f0 = f0_prev;
        this.f1 = f1_next;
    }

    /* computes F(n) using an iterative algorithm, where F(n) = F(n-1)
        + F(n-2) is the recusive definition 
    * use instance variables that store F(0) and F(1)
    * check parameter and throw exception if n < 0. Don't worry about arithmetic
        overflow. */
    public int fItr(int fn)
    {
        if (fn == 0)
        {
            return f0; // because 0+0 = 0 (instance varibale)
        }
        else if (fn == 1)
        {
            return f1; // because 0+1 = 1 (instance variable)
        }
        else
        {
            //initialize fn_0, fn_1, and fn
            int fn_0 = f0, fn_1 = f1, fn_result = 0;

            //iterative case : it goes through each number to compute F(n)
            for (int i = 2; i <= fn; i++)
            {
                fn_result = fn_0 + fn_1; //adds previous and current 
                fn_0 = fn_1; //switches previous to current
                fn_1 = fn_result; // assigns to the next number
            }
            return fn_result;
        }
    }

    /* computes F(n) using a recursive algorithm, where F(n) = F(n-1)
        + F(n-2) is the recusive definition
    */
    public int fRec(int fn)
    {
      if (fn == 0)
        {
            return f0; //because 0+0=0
        }
        else if (fn == 1)
        {
            return f1; //because 0+1 = 1
        }
        else //recursive case : method calls itself with arguments (n-1) and (n-2)
        {
            //compute F(n)
            //F(n) = F(n-1) + F(n-2) as a return value 
            return fRec(fn - 1) + fRec(fn - 2);
            /* called fRec(n3) calls fRec(n2) and fRec(n1)
             * then calls fRec(n2) and fRec(n1)
             * and lastly calls fRec(1) returns f1 and so on.. 
             */
        }
    }

    public static void main(String[] args)
    {
        /* get numbers F(0) and F(1) from args[1]
         * use either the Scanner class or integer.parseInt(args[])
         * must handle possible exceptions
        */

        /* Using the Scanner method to prompt user for input */
        Scanner scanner = new Scanner(System.in);
        int f0_prev, f1_next, fn;

        //prompt user for input 
        try 
        {
            if (args.length < 3) //only 3 values shall be entered
            {
                System.out.println("Please enter only three values, F(0), F(1), and F(n).");

                System.out.println("Enter F(0): ");

                //loop to check if input is valid for F(0)
                try
                {
                    f0_prev = scanner.nextInt(); //takes value from user
                }
                catch (InputMismatchException exception)
                {
                    throw new InputMismatchException("Invalid input for F(0)."); //throws exception
                }
                
                System.out.println("Enter F(1): ");

                //loop to check if input is valid for F(1)
                try 
                {
                    f1_next = scanner.nextInt(); //takes value from user
                }
                catch (InputMismatchException exception)
                {
                    throw new InputMismatchException("Invalid input for F(1)."); //throws exception
                }

                System.out.println("Enter F(n): ");

                try
                //loop to check if input is valid for n
                {
                    fn = scanner.nextInt(); //takes value from user
                    if (fn <= 0)
                    {
                        throw new IllegalArgumentException("F(n) Must be grater than or equal to 1.");
                    }
                }
                catch (InputMismatchException exception)
                {
                    throw new InputMismatchException("Invalid input for F(n)."); //throws exception
                }
            }

            else //if user enters three values at once -> use them accordingly 
            {
                f0_prev = Integer.parseInt(args[0]);
                f1_next = Integer.parseInt(args[1]);
                fn = Integer.parseInt(args[2]);
            }

            //create a Fib object with parameters F(0) and F(1)
            Fib fib_obj = new Fib(f0_prev, f1_next);

            //calculate F(0) to F(n) and display with system.out.println()
            //the iterative method f(i)
            System.out.println("Iterative method results: ");
            
            //display the output and chosen numbers to iterate
            for(int i = 0; i <= fn; i++)
            {
                //index i and index fib(i)
                System.out.println("F(" + i + ") = " + fib_obj.fItr(i));
                //prints results like F(i) = i 
            }

            //calculate F(0) to F(n) and display with system.out.println()
            //the recursive method fRec(i)
            System.out.println("Recursive method results: ");

            //display the out put and chosen numbers to iterate
            for(int i = 0; i <= fn; i++)
            {
                //index i and index fib(i)
                System.out.println("F(" + i + ") = " + fib_obj.fRec(i));
                //prints results like F(i) = i
            }
        }

        //Catches the exceptions and displays their messages 
        catch (IllegalArgumentException exception)
        {
            System.out.println(exception.getMessage());
        }
        
        catch (InputMismatchException exception)
        {
            System.out.println(exception.getMessage());
        }

        finally
        {
            scanner.close(); //closing I/O stream
        }
    }
    //instance varibales store F(0) and F(1):
};