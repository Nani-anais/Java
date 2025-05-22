import java.util.Arrays;
import java.util.NoSuchElementException;

public class QueueTest 
{
    public static void main(String[] args) 
    {
        LQueue<String> queue = new LQueue<>();

        queue.enqueue("A");
        queue.enqueue("B"); //add last 
        queue.enqueue("C");
        queue.enqueue("D");
        queue.enqueue("E");
        queue.enqueue("F");
        System.out.println("Enqueue elements.");
        System.out.println("Size of list after enqueue: " + queue.size()); //print the size of the list
        
        //Test head 
        System.out.println("Head: " + queue.head()); //print the first element of the list

        //Test dequeue
        System.out.println("Dequeued element: " + queue.dequeue()); //remove the first element of the list


        System.out.println("Dequeue next element: " + queue.dequeue()); //remove the next first element of the list
        

        //Test isEmpty
        System.out.println("Is queue empty? " + queue.isEmpty()); //print if the list is empty

        //Test addAll
        String[] arr = {"G", "H", "I", "J", "K"}; //create a string of arrays
        queue.addAll(Arrays.asList(arr)); //add all elements from the array to the list

        System.out.println("Head after addAll: " + queue.head()); //print the head of the list
        System.out.println("Is queue empty after addAll? " + queue.isEmpty()); //print if the list is empty

        //Test dequeue all elements
        System.out.println("Dequeue all elements: ");

        try
        {
            while (!queue.isEmpty()) //while the list is not empty
            {
                System.out.println("Dequeued element: " + queue.dequeue()); //remove the first element of the list
            }
        }
        catch (NoSuchElementException e)
        {
            System.out.println("Queue is empty." + e.getMessage()); //exception handling if the list is already empty
        }
        
        System.out.println("Is queue empty after dequeue all elements? " + queue.isEmpty()); //print if the list is empty
    }
}
