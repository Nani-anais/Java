package IntroductionToJava;
import java.util.Scanner;
public class IfElse 
{
    // void = no return value
    public void Guess(int guess)
    {
        int number = 7;

        //var = condition ? true expr : flase expr
        String result = (number == guess) ? "You guessed right." : "Nope.";

        //send result in to be printed 
        System.out.println(result);
    }
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Guess a number 1-10: ");
        //read input from the user
        //append the next integer in the scanner object
        int guess = scanner.nextInt();
        scanner.close();

        //create an object called: ifElse, to access the method
        IfElse ifElse = new IfElse();
        //call the method with the guess vlaue
        ifElse.Guess(guess);
    }
}
