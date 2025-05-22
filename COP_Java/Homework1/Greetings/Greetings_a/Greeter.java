/* This program swaps the names of this greeter and another instance
* before compiling, make sure to navigate to the base directory .../Homework1/Greetings
* compile : javac Greetings_a/Greeter.java
*/
package Greetings_a;

public class Greeter 
{
    //create a class attribute
    private String name;

    //create a constructor
    public Greeter(String aName)
    {
        name = aName;
    }
    
    //create a getter
    public String getName() 
    {
        return name;
    }

    // and a setter
    public void setName(String aName)
    {
        name = aName;
    }

    //  Create method to return set output 
    public String sayHello()
    {
        return "Hello, " + name + "!";
    }

    // Create accessible method with Greeter as a parameter to swap names 
    public void swapNames(Greeter other)
    {
        //current name stored in a temporary variable temp
        String temp = name; 

        //getName() method passes the current name argument to other and stores it in name
        name = other.getName();

        //the temporary variable temp is sent to setName with current name argument
        other.setName(temp);
    }
}
