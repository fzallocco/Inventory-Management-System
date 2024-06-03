import java.util.*;
class InventoryManagementTest {
  public static void main(String[] args){

        System.out.println("This is the Java Inventory System Management");
        System.out.println("Enter item's name, price, and quantity in the following order below:\n");
        InventoryManagement ivm = new InventoryManagement();
        InventoryManagement.Inventory intmg = ivm.new Inventory();

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter new item? Enter any integer or -1 to exit concole");
        int userInput = scn.nextInt();
        while(userInput != -1 ){
          System.out.println("item's name: \n");
          String itemName = scn.next();
          System.out.println("item's price: \n");
          double itemPrice = scn.nextDouble();
          System.out.println("item's quantity: \n");
          int itemQuantity = scn.nextInt();
          intmg.addItem(itemName, itemPrice, itemQuantity);
          System.out.println("item added to inventory");
          System.out.println("Enter new item? Enter any integer or -1 to exit concole\n");
          userInput = scn.nextInt();
        }
        //adding items to inventory management system
        /*intmg.addItem("Laptop", 999.99, 5);
        intmg.addItem("Mouse", 19.99, 10);
        intmg.addItem("Keyboard", 49.99, 7);*/

        // Displaying inventory
        intmg.displayInventory();

        // Updating item's quantity
        /*intmg.updateItemQuantity("Mouse", 8);

        // Updating item's price
        intmg.updateItemPrice("Mouse", 2.75);
        intmg.removeItem("bananas");*/

        // Displaying updated inventory
        /*intmg.displayInventory();*/

  }//end of main
}//end of class
