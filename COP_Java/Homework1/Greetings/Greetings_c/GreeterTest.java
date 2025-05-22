/* This program shows how the swapNames() and the createQualifedGreeter()
 * methods are used 
 * run from root directory, to nagivate back to root as an example enter 
 * in terminal : cd /Users/.../.../.../Homework1/Greetings
 * compile : javac Greetings_a/Greeter.java Greetings_b/GreeterB.java Greetings_c/GreeterTest.java
 * you have to compile all three files together this way or you will run into a file not found error
 * run : java Greetings_c.GreeterTest
 */
package Greetings_c;
import Greetings_b.GreeterB;
import Greetings_a.Greeter;

public class GreeterTest
{
    public static void main(String[] args)
    {
        //create two instances of Greeter
        Greeter worldGreeter = new Greeter("World");
        Greeter usaGreeter = new Greeter("USA");

        //worldGreeter variable value is passed to sayHello method
        System.out.println(worldGreeter.sayHello());

        //usaGreeter variable value is passed to sayHello method
        System.out.println(usaGreeter.sayHello());

        //call swapNames with worldGreeter attribute and pass usaGreeter argument
        worldGreeter.swapNames(usaGreeter);

        //the worldGreeter variable value is now swapped with usaGreeter
        System.out.println(worldGreeter.sayHello());
        System.out.println(usaGreeter.sayHello());

        //create a new GreeterB object
        GreeterB worldGreeterB = new GreeterB();

        //create a new Greeter object with the name "beautiful" and the greeter's name
        Greeter WorldGreeter2 = worldGreeterB.createQualifiedGreeter(worldGreeter.getName(),"Beautiful");

        //print the new Greeter object's name
        System.out.println(WorldGreeter2.sayHello());
        //will print out USA Beautiful because the names are still swapped
    }
}
