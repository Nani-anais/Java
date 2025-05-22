/* a class that calculates the total price of the products
* compile: javac ProductDB.java CalcReceipt.java 
*/
package Homework2;
import java.util.List;

public class CalcReceipt 
{
    //Method that calculates the total price of the products entered by user
    public double calculateTotalPrice(List<ProductDB.Product> productList)
    {
        //Create a variable to hold the total price
        double totalPrice = 0.0;
        
        //Loop through the list of products
        for(ProductDB.Product product : productList)
        {
            //Add the unit price of each product to the total price
            totalPrice += product.getUnitPrice();
        }
        
        //Return the total price
        return totalPrice;
    }    
}
