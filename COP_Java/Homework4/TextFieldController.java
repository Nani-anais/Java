import java.awt.event.ActionEvent; //subclass for indicating action events 
import java.awt.event.ActionListener; //event interfcae for handling action events
import javax.swing.JTextField; //JTextComponent subclass for editing a single line of text

class TextFieldController implements ActionListener 
{
    //variables 
    private final int index; //value index of the bar graph
    private final ModelNumber model; //model number that controller updates 
    private final JTextField textField; //text field that controller listens for

    //constructor
    public TextFieldController(int index, ModelNumber model, JTextField textField) 
    {
        this.index = index;
        this.model = model;
        this.textField = textField;
    }

    //when user finishes editing in the text field, this method is triggered
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //try to parse the text field input to an integer
        try 
        {
            int newValue = Integer.parseInt(textField.getText());
            model.setValue(index, newValue);
        } 
        catch (IllegalArgumentException exeption) 
        {
            // Handle invalid input
            textField.setText(String.valueOf(model.getValue(index)));
        }
    }
}
