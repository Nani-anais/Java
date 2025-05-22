/* a program that creates a car object with make, model, and built date
 * and sorts the list of cars by make and model, then by built date.
 * cd .../Homework3
 * compile: javac Car.java
 * run: java Car.java
*/
package Homework3;
import java.util.ArrayList;
import java.util.Comparator;

public class Car 
{
    //attributes
    private String make;
    private String model;
    private int builtDate;

    //constructor for car class
    /*Precondition: make && model != null
        *buildDate >= 0
     *Postcondition: A new car object is created with make, model, and builtDate
     *Invariant: attributes are not null and non-negative 
     */
    public Car(String make, String model, int builtDate)
    {
        assert make != null : "Make cannot be null";
        this.make = make;
        this.model = model;
        this.builtDate = builtDate;
    }

    //accessors
    /*Precondition: none
     *Postcondition: returns the make of the car
     *Invariant: attribute is not modified
     */
    public String getMake()
    {
        return make;
    }

    /*Precondition: none
     *Postcondition: returns the model of the car
     *Invariant: attribute is not modified 
     */
    public String getModel()
    {
        return model;
    }

    /*Precondition: none
     *Postcondition: returns the builtDate of the car
     *Invariant: attribute is not modified 
     */
    public int getBuiltDate()
    {
        return builtDate;
    }

    /* compares two car objects and returns a new comparator object by make and model
     * using annonymous classes
     * Precondition: none
     *Postcondition: returns the comparator object that compares two car objects by 
        * make and model
     *Invariant:the state of the cars being compared remains unmodified
     */
    public static Comparator<Car> getCompByMakeModel()
    {
        return new Comparator<Car>() 
        {
            public int compare(Car car1, Car car2)
            {
                //if the make is the same
                if(car1.getMake().compareTo(car2.getMake()) == 0)
                {
                    //compare the model
                    return car1.getModel().compareTo(car2.getModel());
                }
                else
                {
                    //compare the make
                    return car1.getMake().compareTo(car2.getMake());
                }
            }   
        };

    }

    /* compares two car objects by the built date and returns a new comoparator object
     * using annonymous classes
     * Precondition: none
     *Postcondition: returns the comparator object that compares two objects by built date
     *Invariant: the state of the cars being compared remains unmodified
     */
    public static Comparator<Car> getCompByDate()
    {
        return new Comparator<Car>() 
        {
            public int compare(Car car1, Car car2)
            {
                //compare by calculating the difference in built date
                return car1.getBuiltDate() - car2.getBuiltDate();
            }    
        };
    }

    /*
     *Precondition: none
     *Postcondition: displays the list of car objects, fist sorted by make and model, the by
        * built date
     *Invariant: the list of cars itself is not modified
     */
    public static void main(String[] args)
    {
        /*Creating an array list */
        ArrayList <Car> cars = new ArrayList<>();
    
        /* add four new car objects in the list of cars 
        * with make and model */
        cars.add(new Car("Honda", "Accord", 2025));
        cars.add(new Car("Toyota", "Camry", 2024));
        cars.add(new Car("Ford", "Fusion", 2023));
        cars.add(new Car("Chevy", "Malibu", 2022));

        //sorting the list of cars using the getCompByMakeModel method
        cars.sort(Car.getCompByMakeModel());

        //displaying the sorted list
        System.out.println("Sorting the list of cars by Make and model: \n");
        for(Car car : cars)
        {
            System.out.println("Car Make: " + car.getMake() + "\n Car Model: " + car.getModel() + "\n Manufacture date: " + car.getBuiltDate());
        }

        //sorting the lis of cares by the manufacture date 
        cars.sort(Car.getCompByDate());

        //displaying the sorted list
        System.out.println("\nSorting the list of cars by Manufacture date: \n");
        for(Car car : cars)
        {
            System.out.println("Car Make: " + car.getMake() + "\n Car Model: " + car.getModel() + "\n Manufacture date: " + car.getBuiltDate());
        }

    }
}
