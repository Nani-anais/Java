import java.util.ArrayList;
import java.util.List;

public class ModelNumber 
{
    private final List<Integer> values; //a list to hold values in bar 
    private final List<ModelObserver> observers; //list of objects to notify data changes

    //constructor
    public ModelNumber() 
    {
        values = new ArrayList<>(); //initialize list to hold bar values
        observers = new ArrayList<>(); //initialize list to hold listener
    }

    //interface to define the observer behavior
    interface ModelObserver 
    {
        void update(); //method to update the bar component
    }

    //method to register when data changes 
    public void addObserver(ModelObserver observer) 
    {
        observers.add(observer); //adds the observer to the list
    }

    //method to get list size of values
    public int getSize() 
    {
        return values.size(); //return size of values list
    }

    //method that gets the value at an index
    public int getValue(int index) 
    {
        return values.get(index); //returns index values
    }

    //method that adds a new value to the list 
    public void addValue(int value) 
    {
        values.add(value); //adds to values array list

        notifyObservers(); //calls to change
    }

    //method that updates the value 
    public void setValue(int index, int value) 
    {
        if (value >= 0 && value <= 100) 
        {
            values.set(index, value);
            notifyObservers(); //calls to notify update of change 
        }
        else 
        {   //throws exception if value is out of range
            throw new IllegalArgumentException("Value must be between 0 and 100"); 
        }
    }

    //method to call update when a change is notified
    private void notifyObservers() 
    {
        //iterates over each ModelObserver observer element 'observers'
        for (ModelObserver observer : observers) 
        {
            observer.update(); //call update
        }
    }
}