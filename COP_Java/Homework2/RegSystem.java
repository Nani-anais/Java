/* Application that simulates a cash register 
* compile: javac ProductDB.java CalcReceipt.java RegSystem.java
* run: java RegSystem.java
*/
package Homework2;
import java.util.Scanner;
import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class RegSystem {
    
    public static void main(String[] args)
    {
        //Creat a Scanner object
        Scanner scanner = new Scanner(System.in);

        //Creat object of ProductDB
        ProductDB db = new ProductDB();
        db.addSampleProducts();

        //Create a list that will store the products entered by user
        List<ProductDB.Product> productList = new ArrayList<>();

        //promt user to enter the key (UPC)
        System.out.println("Enter the UPC code of the product, enter 'PAY' to finish: ");

        while(true)
        {
            //read the UPC code (key)
            String upcKey = scanner.nextLine();

            //Check if user finished scanning by entering key word 'PAY'
            if (upcKey.equalsIgnoreCase("PAY"))
            {
                break;
            }

            //Look up the UPC key in the DB using the getProduct method 
            ProductDB.Product product = db.getProduct(upcKey);

            //Display the product in the DB if found
            if(product != null)
            {
                //product (object) = itemName (Name) + unitPrice (Price)
                System.out.println("Product found: " + product);

                //add the product to the list
                productList.add(product);
            }
            else
            {
                System.out.println("Product not found for UPC: " + upcKey);
            }
        }
        //Close the input stream scanner object
        scanner.close();

        //Create object of CalcReceipt
        CalcReceipt calcReceipt = new CalcReceipt();

        //calculate total price using CalcReceipt
        double totalPrice = calcReceipt.calculateTotalPrice(productList);

        //Print Receipt 
        System.out.println("Receipt: ");
        for(ProductDB.Product product : productList)
        {
            System.out.println(product);
        }
        //Create new object DF to format the total price 
        DecimalFormat DF = new DecimalFormat(".00");
        System.out.println("Total price: $" + DF.format(totalPrice));
    }
}
