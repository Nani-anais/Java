import java.io.Serializable;
import java.util.Objects;

public class Pair<K, V> implements Serializable, Cloneable
{
    // to ensure that the class can be serialized
    private static final long serialVersionUID = 1L; //serial version UID

    // declare the key and value of the pair
    private K key;
    private V value;

    // constructor to initialize the key and value
    public Pair(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    //Accessors for the key and value
    public K k()
    {
        return key;
    }

    public V v()
    {
        return value;
    }

    //methods inherited from the Object class
    
    //Override the equals method to compare the key and value of the pair
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true; //return true if the object is the same
        } 
        if (obj == null || getClass() != obj.getClass())
        {
            return false; //return false if the object is null or not the same class
        } 

        Pair<?, ?> pair = (Pair<?, ?>) obj; //cast the object to a pair

        //return true if the key and value are the same
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
    }

    //Override the hashCode method to return the hash code of the key and value
    @Override
    public int hashCode()
    {
        return Objects.hash(key, value); //return the hash code of the key and value
    }

    //Override the toString method to return the string representation of the key and value
    @Override
    public String toString()
    {
        return "Pair (" + "Key= " + key + ", value= " + value + ")"; //return the string representation of the
    }

    //Override the clone method to return a copy of the pair
    @Override
    public Object clone()
    {
        try 
        {
            return super.clone(); //return a copy of the pair
        }
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError(e); //throw error if the pair cannot be cloned
        }
    }
}
