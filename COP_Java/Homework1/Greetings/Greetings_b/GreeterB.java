/*This program returns a new Greeter object with its name being the qualifier string
 * followed by " " and the executing greeter's name 
 * compile : javac Greetings_a/Greter.java Greetings_b/GreeterB.java
 * you need to include the imported file when compiling aswell!
 */
package Greetings_b;
import Greetings_a.Greeter;

public class GreeterB
{
    //create a method that returns a new greeter object  
    public  Greeter createQualifiedGreeter(String qualifier, String name)
    {
        //calls GreeterB with name and qualifier argument
        return new Greeter(qualifier + " " + name);
    }
}
