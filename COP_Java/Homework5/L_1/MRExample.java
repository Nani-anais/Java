package L_1;
/* This program illustrates how to use a functional interface
* This program demonstrates the use of lambda expressions to implement
* the map and reduce operations on a list of strings.
* This program is a complete version of the previous one MRExampleWithLamdas, 
* with the addition of the LengthFun and Summer classes*/
public class MRExample
{
    public static void main(String[] args)
    {
        //Create a list of strings
        MyListWithReduce<String> ls = new MyListWithReduce<>();
        ls.add("Hello"); //Add elements to the list
        ls.add("Everyone");
        ls.add("You're");
        ls.add("Welcome");
        //Create an instance of the LengthFun class
        LengthFun lengthFun = new LengthFun();
        //Map the list using the LengthFun class
        MyListWithReduce<Integer> li = new MyListWithReduce<>();
        li.addAll(ls.map(lengthFun)); // Convert mapped result to MyListWithReduce
        System.out.println("List of lengths: " + li);
        //Create an instance of the Summer class
        Summer summer = new Summer();
        //Map the list using the Summer instance
        Integer totalLength = li.reduce(summer, 0);
        System.out.println("Total number of characters: " + totalLength);
    }
}