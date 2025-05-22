import java.io.*;

public class PairTest 
{
    public static void main(String[] args) 
    {
        //Test the equals method
        Pair<Integer, String> p1 = new Pair<>(1, "One");
        Pair<Integer, String> p2 = new Pair<>(1, "One");
        Pair<Integer, String> p3 = new Pair<>(2, "Two");
        Pair<Integer, String> p4 = new Pair<>(1, "Two");

        //print the pairs
        System.out.println("p1 " + p1.toString());
        System.out.println("p2 " + p2.toString());
        System.out.println("p3 " + p3.toString());
        System.out.println("p4 " + p4.toString());

        System.out.println("p1 equals p2? " + p1.equals(p2)); //true
        System.out.println("p1 equals p3? " + p1.equals(p3)); //false
        System.out.println("p1 equals p4? " + p1.equals(p4)); //false

        //Test the cloning method
        @SuppressWarnings("unchecked") //suppress the warning for unchecked casting 
        Pair<Integer, String> p4Clone = (Pair<Integer, String>) p4.clone();
        System.out.println("p4 equals p4Clone? " + p4.equals(p4Clone)); //true

        //Test the hashCode method
        System.out.println("p1 hash code: " + p1.hashCode());
        System.out.println("p2 hash code: " + p2.hashCode());
        System.out.println("p3 hash code: " + p3.hashCode());
        System.out.println("p4 hash code: " + p4.hashCode());

        //Test the serialization method
        try
        {
            //Serialize the pair object to a file
            //Create a file output stream to write the object to a file
            FileOutputStream s_fileOut = new FileOutputStream("Pair object serialized");

            //Create an object output stream to write the object to the file
            ObjectOutputStream s_out = new ObjectOutputStream(s_fileOut);

            s_out.writeObject(p1); //Write the pair object to the file
            
            s_out.close(); //Close the object output stream
            
            s_fileOut.close(); //Close the file output stream

            //Deserialize the pair object from a file
            //Create a file input stream to read the object from a file
            FileInputStream d_fileIn = new FileInputStream("Pair object serialized");

            //Create an object input stream to read the object from the file
            ObjectInputStream d_in = new ObjectInputStream(d_fileIn);

            //Read the pair object from the file
            @SuppressWarnings("unchecked") //suppress the warning for unchecked casting
            Pair<Integer, String> Deserialized = (Pair<Integer, String>) d_in.readObject();

            d_in.close(); //Close the object input stream

            d_fileIn.close(); //Close the file input stream

            //Print the deserialized pair object
            System.out.println("Deserialized pair object: " + Deserialized.toString());
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace(); // Handle the exception
        }
        finally
        {
            System.out.println("End of the program.");
        }
    }
    
}
