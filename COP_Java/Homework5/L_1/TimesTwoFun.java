package L_1;
import java.util.LinkedList;
// This program illustrates how to use a functional interface 
// implementing Functor<R, T> interface from LengthFun.java
class TimesTwoFun implements Functor<Integer, Integer>
{
    @Override
    public Integer apply(Integer param)
    {
        return param * 2; //Return the parameter multiplied by 2
    }
}
//Subclass of LinkedList that implements the map method
class MyList<T> extends LinkedList<T>
{
    public <R> MyList<R> map(Functor<R, T> fo)
    {
        //Create a list to store the mapped elements
        MyList<R> newList = new MyList<>();
        //Apply the function to each element in the list
        for (T element : this)
        {
            //Add the result of the function to the list
            newList.add(fo.apply(element));
        }
        return newList; //Return the list with the mapped elements
    }
    public static void main(String[] args)
    {
        //Create a list of integers
        MyList<Integer> lst = new MyList<>();
        lst.add(-2); //Add elements to the list
        lst.add(1);
        lst.add(0);
        lst.add(4);
        //Create an instance of the TimesTwoFun class
        TimesTwoFun tt = new TimesTwoFun();
        //Map the list using the TimesTwoFun class
        MyList<Integer> mappedList = lst.map(tt);
        System.out.println("Mapped list using TimesTwoFun: " + mappedList);
        // Using a lambda expression
        Functor<Integer, Integer> lambdaTimesTwo = x -> x * 2;
        //Map the list using the lambda expression
        MyList<Integer> lambdaMappedList = lst.map(lambdaTimesTwo);
        System.out.println("Mapped list using lambda: " + lambdaMappedList);
    }
}