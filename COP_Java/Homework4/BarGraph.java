/* Main class that creates the frame and invokes the GraphView class
 * This class is the entry point for the program and sets up the GUI.*/
import javax.swing.JFrame; //Import the JFrame class from the javax.swing package

//Driver 
public class BarGraph 
{
    public static void main(String[] args) 
    {
        //create a new ModelNumber object that holds the values for bar graph
        ModelNumber model = new ModelNumber();

        //add some example values to the panel
        model.addValue(40);
        model.addValue(70);
        model.addValue(90);

        //create a new JFrame object and set the title for the window
        JFrame frame = new JFrame("Editable Bar Graphs");

        //set a default closing operation for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit when user closes window

        frame.setSize(500, 200); //set the default frame size 
        
        //call the GraphView as a new object to pass the model to the frame
        frame.add(new GraphView(model)); //this adds GraphView as a parameter

        //method derived from Window parent class
        frame.setVisible(true); //To make visible, displays the frame
    }
}