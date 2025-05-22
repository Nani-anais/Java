package L_1;
/* This program illustrates how to use a functional interface
* This program demonstrates the use of lambda expressions to implement
* the map and reduce operations on a list of strings.*/

public class MRExampleWithLambdas
{
    public static void main(String[] args)
    {
        //Create a list of strings
        MyListWithReduce<String> ls = new MyListWithReduce<>();
        ls.add("Hello"); //Add elements to the list
        ls.add("World");
        ls.add("Functional");
        ls.add("Programming");
        // Chain map and reduce using lambdas
        MyListWithReduce<Integer> lengths = new MyListWithReduce<>();
        //Map the list using a lambda expression -> that returns the length of the string
        lengths.addAll(ls.map((String s) -> s.length())); // Convert mapped result to MyListWithReduce
        //Map the list using a lambda expression -> that reduces the list to a single value
        Integer totalLength = lengths.reduce((x, y) -> x + y, 0); //reduce using a lambda expression
        System.out.println("Total number of characters using lambdas: " + totalLength);
    }
}