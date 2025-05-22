import java.util.Collection; // for addAll method used by MyQueue
import java.util.NoSuchElementException; // for exception handling
import java.util.LinkedList; // existing class adaptee 

public class LQueue<E> implements MyQueue<E> 
{
    //Create a new object of the LinkedList class
    private LinkedList<E> list = new LinkedList<>();

    //return the top of the queue element or throw NoSuchElementException if empty
    public E head()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        return list.getFirst(); //return the first element of the list
    }

    //remove and return the top of the queue element or throw NoSuchElementException if empty
    public E dequeue()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        return list.removeFirst(); //remove the first element of the list
    }

    //add an element to the end of the queue
    public void enqueue(E e)
    {
        list.addLast(e); //add an element to the end of the list
    }

    //return the size of the queue
    public int size()
    {
        return list.size(); //return the size of the list
    }

    //return true if the queue is empty 
    public boolean isEmpty()
    {
        return list.isEmpty(); //return true if the list is empty
    }

    /*
     add elements to this queue from a collection c of E references
     voided method that does not return a value 
     appeneds all elements to the end of the list by the order they are returned by iterator 
    */
    public void addAll(Collection <? extends E> c)
    {
        list.addAll(c); //add all elements from the collection to the list
    }
}