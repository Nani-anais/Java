/* A program that displays a frame with GUI button elements that
 * change the color of the text field when clicked.
 * The program will invoke a new window displaying a rectangle where you can chnage 
 * the color of the rectangle by clicking the buttons.
 * cd .../Homework3
 * compiled by: javac Button.java
 * run by: java Button.java
 */
package Homework3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Button implements Icon
{
    private Color color;

    /*Constructors
     *Precondition: initialColor != null
     *Postcondition: a new button object is made
     *Invariant: the color attribute is a valid color object 
     */
    public Button(Color initialColor)
    {
        assert initialColor != null : "Initial color cannot be null.";
        this.color = initialColor;
    }

     /*
     *Precondition: newColor != null
     *Postcondition: button color is updated to a new color 
     *Invariant: attribute color holds the valid color object
     */
    public void setColor(Color newColor)
    {
        assert newColor != null : "New color cannot be null.";
        this.color = newColor;
    }

     /*
     *Precondition: c && g != null
     *Postcondition: the rectangle is painted with the current color at the coordinates with
        * the width and height of the icon
     *Invariant: the rectangle is painted with the current color of the button clicked
     */
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        assert c != null : "Component cannot be null.";
        assert g != null : "Graphics object cannot be null.";
        g.setColor(color);
        g.fillRect(x, y, getIconWidth(), getIconHeight());
    }

     /*
     *Precondition: none
     *Postcondition: returns the fixed width of the icon
     *Invariant: the width is fixed 
     */
    public int getIconWidth()
    {
        return 210;
    }

    /*
     *Precondition: none
     *Postcondition: returns the fixed height of the icon
     *Invariant: the height is fixed
     */
    public int getIconHeight()
    {
        return 190;
    }

    /*Method that creates the buttons
     * Precondition: label && color && icon && labelComponent != null
     * Postcondition: a new button is created with the label, color, icon, and labelComponent
     * Invariant: the button is created with the label, color, icon, and labelComponent
     */
    public static JButton createButton(String label, Color color, Button icon, JLabel labelComponent)
    {
        //creates a new button with the label
        JButton button = new JButton(label);

        //attaching an anonymous action listener to change the colors of the rectangle 
        button.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent event)
            {
                //changing the rectangles color
                icon.setColor(color);

                //requesting the lable to repaint
                labelComponent.repaint();
            }
        });
        return button;
    }

    /*
     *Precondition: none
     *Postcondition: JFrame is created and displays the rectangle. buttons, and icons.
     *Invariant: Button object is always displayed in the JLabel
     */
    public static void setupFrame()
    {
        //creating the main frame
        JFrame frame = new JFrame("Color changing rectangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        //Creating the icon and label
        Button colorIcon = new Button(Color.YELLOW);
        JLabel iconLabel = new JLabel(colorIcon);

        //Creating the panel for the buttons
        JPanel buttonPanel = new JPanel();

        //An array that holds the button lables 
        String[] lables = {"Yellow","Blue","Red"};

        //Another array that holds all the colors
        Color[] colors = new Color[]{Color.YELLOW, Color.BLUE, Color.RED};

        //Creates the buttons and adds them to the panel
        for(int i = 0; i < lables.length; i++)
        {
            JButton button = createButton(lables[i], colors[i], colorIcon, iconLabel);
            buttonPanel.add(button);
        }

        //adding the components to the frame
        frame.setLayout(new BorderLayout());
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(iconLabel, BorderLayout.CENTER);

        //setting the frame to be visible
        frame.setVisible(true);
    } 

    /*
     *Precondition: none
     *Postcondition: the setupFrame method is called by SwingUtilities.InvokeLater() and 
        * esures the frame is displayed 
     *Invariant: the process of setting up the frame does not modify the state of the buttons and 
        *lables when clicked
     */
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> setupFrame());
    }
}
