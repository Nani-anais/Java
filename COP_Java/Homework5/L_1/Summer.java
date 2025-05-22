package L_1;
//this program illustrates how to use a functional interface

//takes a parameter of type T1 and T2 and returns a result of type R
interface Functor2<R, T1, T2>
{
    R apply(T1 param1, T2 param2);
}
class Summer implements Functor2<Integer, Integer, Integer>
{
    @Override
    public Integer apply(Integer param1, Integer param2)
    {
        return param1 + param2; //Return the sum of the two parameters
    }
}
class MyListWithReduce<T> extends MyList<T>
{
    public T reduce(Functor2<T, T, T> fo2, T initialValue)
    {
        //Initial result is the initial value
        T result = initialValue;
        for (T element : this)
        {
            //Apply the sum function to the result and the element
            result = fo2.apply(result, element);
        }
        return result;
    }
    public static void main(String[] args)
    {
        //Create a list of integers
        MyListWithReduce<Integer> lst = new MyListWithReduce<>();
        lst.add(3); //Add elements to the list
        lst.add(-1);
        lst.add(1);
        lst.add(4);
        //Create an instance of the Summer class
        Summer summer = new Summer();
        //Map the list using the Summer instance
        Integer sum = lst.reduce(summer, 0);
        System.out.println("Sum using Summer: " + sum);
        // Using a lambda expression -> that also returns the sum of the elements
        Functor2<Integer, Integer, Integer> lambdaSummer = (x, y) -> x + y;
        Integer lambdaSum = lst.reduce(lambdaSummer, 0);
        System.out.println("Sum using lambda: " + lambdaSum);
    }
}