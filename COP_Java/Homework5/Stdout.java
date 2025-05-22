public class Stdout 
{
    public void printline(String s)
    {
        System.out.println(s);
    }

    //create an instance of the Stdout class
    private static final Stdout instance = new Stdout();

    //create a private constructor to prevent instantiation
    private Stdout(){}

    /*
     * public static method to get access to the single instance of the class
     * returns a reference to the single instance 
     */
    public static Stdout getInstance()
    {
        /*
        //check if the instance is null but not neccessary
        if (instance == null)
        {
            return new Stdout();
        }
        else 
        {
            System.out.println("Instance already exists.");
        }
        */
        return instance;
    }

    //Main method to test the class
    public static void main(String[] args)
    {
        Stdout out = Stdout.getInstance();
        out.printline("Hello, World!");
        out.printline("Hello, again!");
        out.printline("Hello, one more time!");
    }
}