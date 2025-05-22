package L_1;
// This program illustrates how to use a functional interface

interface Functor<R, T>
{
    //apply(p) takes a parameter of type T and returns a result of type R
    R apply(T param);
}
public class LengthFun implements Functor<Integer, String>
{
    @Override
    //apply(p) returns the length of the string p as an integer value
    public Integer apply(String param)
    {
        return param.length();
    }
    public static void main(String[] args)
    {
        LengthFun lengthFun = new LengthFun();
        String testString = "Illustrates how the class is used to print the length of a string.";
        System.out.println("\"" + testString + "\"" + "\n Has a length of: " +lengthFun.apply(testString));
        // Using lambda expression -> that also returns the length of the string
        Functor<Integer, String> lambdaLengthFun = s -> s.length();
        System.out.println("\"" + testString + "\" \n Using lambda, it has a length of: " +
        lambdaLengthFun.apply(testString));
    }
}