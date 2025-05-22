/*class that holds the product data base in a hash map
    * The key is the UPC code and the value is the product object
    * The product object contains the item name and unit price
* cd .../Homework2 into the base directory
* compile: javac ProductDB.java
* run: java ProductDB.java
*/
package Homework2;
import java.util.HashMap;

public class ProductDB {
    //Create a hashmap object with two key pair values of <String, object>
    //use an object because maps only use pairs, so create object to contain more details
    HashMap<String, Product> productDB = new HashMap<>();

    //Add product to the DB: UPC code, item name [Name], and unit price [Price]
    public void addProduct(String UPC, String itemName, double unitPrice)
    {
        //Create a new product object with the item name and unit price
        Product product = new Product(itemName, unitPrice);

        //"put" keyword puts the <key, value> in the productDB map
        productDB.put(UPC, product);
    }

    //method that adds a few sample products into the DB
    public void addSampleProducts()
    {
        //Add products to the DB
        addProduct("001", "Apples [1 lb]", 3.99);
        addProduct("002", "Bananas [1 lb]", 2.59);
        addProduct("003", "Oranges [1 lb]", 3.79);
        addProduct("004", "Grapes [pack]", 1.99);
        addProduct("005", "Kiwis [1 lb]", 2.99);
        addProduct("006", "Mangos [1 lb]", 3.50);
        addProduct("007", "Pineapple", 3.99);
        addProduct("008", "Watermelon", 4.99);
        addProduct("012", "Apple", 0.65);
        addProduct("022", "Banana", 0.59);
        addProduct("032", "Orange", 0.79);
        addProduct("052", "Kiwi", 0.50);
        addProduct("062", "Mango", 0.89);

    }

    //Nested class for the products
    public class Product
    {
        //Create instance variables 
        private String itemName;
        private double unitPrice;

        //Create constructors for the instance variables
        public Product(String itemName, double unitPrice)
        {
            //this.<instance> = <constructor>
            this.itemName = itemName;
            this.unitPrice = unitPrice;
        }

        /*Override the toString method to output the correct strings 
            if not it will print something like UPC: 001, Homework2.ProductDB$Product@68fb2c38
            the class name@ object hash code */
        @Override
        //method that combines item name and unit price into a String of an object [Product(itemName, unitPrice)]
        public String toString()
        {
            //Breaking it down into smaller parts by using varibales to hold strings 
            String Name = "description: " + itemName;
            String Price = "Item price $" + unitPrice;

            //One more variable to combine the two strings
            String combineString = Name + ", " + Price;

            //returns a string that has a string variable of two more string variables 
            return "Product " + combineString + "";
        }

        //method to return the unit price, used for receipt 
        public double getUnitPrice()
        {
            return unitPrice;
        }
    }

    //method that returns a product from the DB by using UPC key
    public Product getProduct(String UPC)
    {
        //return the product object from the productDB map
        return productDB.get(UPC);
    }

    //method that returns the product unit price from the DB  by corresponding UPC key
    public double getProductPrice(String UPC)
    {
        Product product = productDB.get(UPC);

        //return the product unit price from the productDB map
        return product.getUnitPrice();
    }

    /* For displaying the entire DB
    // Method to display all products
    public void displayProducts() {
        for (String UPC : productDB.keySet()) {
            System.out.println("UPC: " + UPC + ", " + productDB.get(UPC));
        }
    }

    public static void main(String[] args) {
        ProductDB db = new ProductDB();
        db.addSampleProducts();
        db.displayProducts();
    }
    */
}
