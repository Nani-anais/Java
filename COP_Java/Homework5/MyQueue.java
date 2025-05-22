import java.util.Collection; // for addAll method used by MyQueue

// Define the MyQueue interface
interface MyQueue<E> 
{
    E head();
    E dequeue();
    void enqueue(E e);
    int size();
    boolean isEmpty();
    void addAll(Collection<? extends E> c);
}