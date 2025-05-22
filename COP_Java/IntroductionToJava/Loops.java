package IntroductionToJava;
import java.util.Scanner;
import java.util.ArrayList;
public class Loops 
{
    public void while(int wnum)
    {
        while(wnum < 5)
        {
            System.out.println(wnum);
            wnum++; //increment so when it comapres the value it will stop
        }
    }

    public void doWhile(String words)
    {
        do
        {
            System.out.println("Hey!");
        }
        while(words == "Hello");
    }

    public void for(int fnum)
    {
        for(int i = 0 ; i < fnum ; i++)
        {
            System.out.println(i + "iteration.");
        }
    }

    public void forEach(String something)
    {
        for (String i : fElist)
        {
            System.out.println(i);
        }
    }

    private ArrayList <String> fElist = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        forEachLoop fEloop = new forEachLoop();

        System.out.println("Enter a number: ");
        int wnum = scanner.nextInt();

        System.out.println("Say hello: ");
        String words = scanner.nextLine();

        System.out.println("Enter number of times to iterate: ");
        int fnum = scanner.nextInt();
        

        System.out.println("List something: ");
        String something = scanner.nextLine();
        fEloop.fElist.add(something);


    }
} 
