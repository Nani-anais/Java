/* This is a JUnit test class for the NVector class.
* it contains various test methods to verify the functionality of the NVector class.
 */
package Homework3;
import org.junit.*;
import static org.junit.Assert.*;
public class TestNVector 
{
    @Test
    public void testVarargConstructor() {
        System.out.println("Run test constructor");
        NVector vec = new NVector(1.0, 2.0, 3.0);
        //Test conditions
        assertEquals(3, vec.length());
        assertEquals(1.0, vec.get(0), 0.001);
        assertEquals(2.0, vec.get(1), 0.001);
        assertEquals(3.0, vec.get(2), 0.001);
    }

    @Test
    public void testEquals() {
        System.out.println("Run test equals");
        NVector v1 = new NVector(1.0, 2.0, 3.0);
        NVector v2 = new NVector(1.0, 2.0, 3.0);
        //Test condition
        Assert.assertTrue(v1.equals(v2));
    }

    @Test
    public void testGet() {
        System.out.println("Run test get");
        NVector vec = new NVector(5.0, 6.0, 7.0);
        assertEquals(5.0, vec.get(0), 0.001);
        assertEquals(6.0, vec.get(1), 0.001);
        assertEquals(7.0, vec.get(2), 0.001);
    }

    @Test
    public void testAdd() {
        System.out.println("Run test add");
        NVector v1 = new NVector(1.0, 2.0);
        NVector v2 = new NVector(-1.0, 3.0);
        NVector result = v1.add(v2);
        NVector expected = new NVector(0.0, 5.0);
        //Test condition using the equals() method: 
        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void testSprod() {
        System.out.println("Run test sprod");
        NVector v1 = new NVector(1.0, 2.0, 3.0);
        NVector v2 = new NVector(4.0, 5.0, 6.0);
        double result = v1.sprod(v2);
        //Tes consition
        Assert.assertEquals(32.0, result, 0.001);
    }

    @Test
    public void testToString() {
        System.out.println("Run test toString");
        NVector vec = new NVector(3.14, 2.71);
        //Test condition
        Assert.assertEquals("[3.14, 2.71]", vec.toString());
    }
}
