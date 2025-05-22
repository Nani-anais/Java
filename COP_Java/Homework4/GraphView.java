
import javax.swing.JPanel; //imports from java.awt package for GUI in java
import javax.swing.JComponent; //imports from java.swing package for GUI components
import javax.swing.JTextField; //imports from java.swing package for text field components
import java.awt.Color; //imports from java.awt package for color components
import java.awt.Graphics; //imports from java.awt package for graphics components
import java.awt.GridLayout; //imports from java.awt package for layout components

/* Class to create the view of the graph
 * GraphView is a subclass of JPanel and implements ModelNumber.ModelObserver interface
 * GraphView observes the ModelNumber class
 * GraphView implements ModelObserver method defined in ModelNumber class
 */
public class GraphView extends JPanel implements ModelNumber.ModelObserver 
{
    private final ModelNumber model; //instance that the view observes

    //Constructor 
    public GraphView(ModelNumber model)
    {
        this.model = model; //asign passed parameter to variable
        model.addObserver(this); //notifies GraphView when model changes 

        //Sets layout to Gridlayout with rows equal to model size and two columns 
        setLayout(new GridLayout(model.getSize(), 2));
        initializeComponents();//calls to set up components
    }
    
    //Method to set up the view components
    private void initializeComponents()
    {
        removeAll(); //removes components from GraphView panel
        
        //for each value in the model
        for (int i = 0; i < model.getSize(); i++) 
        {
            //create a new bar for each value in the model to add to the GraphView panel
            add(new BarComponent(i)); 

            //create a new text field for each value in the model to add to the GraphView panel
            JTextField textField = new JTextField(String.valueOf(model.getValue(i)));

            //add a new key listener to each text field
            textField.addActionListener(new TextFieldController(i, model, textField));

            //add the text field to the GraphView panel
            add(textField);
        }

        revalidate(); //revalidate 

        repaint(); 
    }

    //method to redraw the View with updated values
    @Override
    public void update() 
    {
        initializeComponents();
    }

    //method to draw and fill contents 
    private class BarComponent extends JComponent 
    {
        //final instance of the index 
        private final int index;

        //Constructor 
        public BarComponent(int index) 
        {
            this.index = index;
        }

        //method to paint the component
        @Override
        protected void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            g.setColor(index == 0 ? Color.RED : (index == 1 ? Color.YELLOW : Color.BLUE));
            int width = model.getValue(index);
            g.fillRect(0, 0, width, 30);
        }
    }
}
