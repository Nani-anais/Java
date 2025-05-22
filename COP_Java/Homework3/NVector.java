/* Implementing a class representing a vector with n elements
 * (v[0],..v[n-1]) with v[i] a double number.
 * the class stores the numbers in an array double v[n]
 * cd .../Homework3
 * compile: javac NVector.java
 * run: java NVector.java
 */
package Homework3;
import java.util.Arrays;
public class NVector 
{
    private double[] v;

    /* n is initialized to zero
     * Constructor that creates a vector of size n 
     * Precondition: n >= 0
     * Postcondition:A new NVector object is created with an internal array of size n initialized to zero
     * Invariant: The internal array v is not null and has a length of n
     */
    public NVector(int n)
    {
        assert n >= 0 : "Vector dimension must be non-negative.";
        this.v = new double[n];
    }

    /* A copy constructor that creates a copy of vector v to the other object 
     * Precondition: other array != null
     * Postcondition: a new vector object created with an internal array that is a copy of the other vector array
     * Invariant: the internal array v is not null and havs equal length with the other array
    */
    public NVector(NVector other)
    {
        assert other != null : "Other vector must be initialized, it cannot be null.";
        this.v = copyArray(other.v);
    }

    /* A method that returns the size of the vector v
     * Precondition: none
     * Postcondition: the length of the internal array v is returned
     * Invariant: the internal array v is not modified 
     */
    public int length()
    {
        return v.length;
    }

    /* A method that returns the size of the vector
     * Precondition: array != null
     * Postcondition: a new array is returned that is a copy of the input array
     * Invariant:the input array is not modified during copying
    */
    private double[] copyArray(double[] array)
    {
        //Arrys.copyOf(original array, length of new copy)
        return Arrays.copyOf(array, array.length);
    }

    /* Vararg constructor that will directly pass elements of the vector v
     * as arguments to the other vector
     * Precondition: array v != null
     * Postcondition: a new NVector object is created containing the internal array values
     * Invariant: the internal array is not null and has an equal legnth in arguments
     */
    public NVector(double...v)
    {
        assert v != null : "Vector V must be initialized, it cannot be null.";
        this.v = Arrays.copyOf(v, v.length); //initialize the internal array directly
    }

    /* Accessor method that gets and returns the element at index i 
     * Precondition: 0 <= i < n
     * Postcondition: element at index i is returned 
     * Invariant: the internal array is not modified 
    */
    public double get(int i)
    {
        assert i >= 0 && i < length() : "Index must be within the bounds of the vector.";
        return v[i];
    }

    /* A method that compares two vector objects
     * Precondition: other array != null
     * Postcondition: remains true if the vectors are equal otherwise false
     * Invariant: internal array and the other array are not modified
     */
    public boolean equals(NVector other)
    {
        assert other != null : "Other Vector must be initialized, it cannot be null.";
        if (this == other)
        {
            return true;
        }
        return Arrays.equals(v, other.v);
    }

    /* A method that returns a new copy of the vector with just one element chnaged
     * Precondition: 0 <= i < n
     * Postcondition: NVector is retuned with the element at index i changed to x
     * Invariant: vector v is not modified, only the new vector reflects changed element
     */
    public NVector set(int i, double x)
    {
        assert i >= 0 && i < length() : "Index must be within the bounds of the vector.";
        NVector copy = new NVector(this);
        copy.v[i] = x;
        return copy;
    }

    /* A method that adds vector v with the other vector and returns a new vector 
     * Precondition: other != null && this.length() == other.length()
     * Postcondition: NVector is returned 
     * Invariant: original vector and the other vectore are not modified
     */
    public NVector add(NVector other)
    {
        assert other != null && length() == other.length() : "Vector cannot be null and  must be of the same length.";
        NVector copy = new NVector(this.length());
        for (int i = 0; i < length(); i++)
        {
            copy.v[i] = this.get(i) + other.get(i);
        }
        return copy;
    }

    /* A method that returns a scalor product of vector v and the other vector
     * Precondition: other != null && this.length() == other.length()
     * Postcondition: returns the scalar product of the two vectors 
     * Invariant: vector v and the other vector is not modified
     */
    public double sprod(NVector other)
    {
        assert other != null && this.length() == other.length() : "Vector cannot be null and must have the same lenght.";
        double scalarSum = 0.0;
        for (int i = 0; i < length(); i++)
        {
            scalarSum += this.get(i) * other.get(i);
        }
        return scalarSum;
    } 

    /*A method that returns a string representation of the vector
     *Precondition: none
     *Postcondition: returns a string of the internal array v
     *Invariant: the internal array v is not modified
    */
    @Override
    public String toString()
    {
        return Arrays.toString(v);
    }

    //main method to demonstrate functionality
    public static void main(String[] args)
    {
        /*Creating an initialized NVector object of elements
        * Calling the vararg constructor passing these elements 
        */
        NVector var1 = new NVector(1, 2, 3, 4);
        NVector var2 = var1.set(1, -5); //set(index, value)

        System.out.println("Original: " + var1);
        System.out.println("Modified: " + var2);

        NVector sum = var1.add(var2);
        System.out.println("Sum: " + sum);
        
        double scalar = var1.sprod(var2);
        System.out.println("Scalar Product: " + scalar);
    }
}
