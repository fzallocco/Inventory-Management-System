import java.util.*;

class InventoryManagement {

  class Item {

    private String name;
    private double price;
    private int quantity;
    private Object lock; //object lock for synchronization

    Item(String name, double price, int quantity){
      this.name = name;
      this.price = price;
      this.quantity = quantity;
      this.lock = new Object(); //Object initializes lock
    }

    //Getters and Setters

    public String getName() {
      return name;
    }

    public double getPrice() {
      return price;
    }

    public int getQuantity() {
      return quantity;
    }

    public double getValue() {
      double product = price*quantity;
      return product;
    }

    public void setName(String name) {
      this.name = name;
    }

    public void setPrice(double price) {
      try{
          if(price >= 0.00)
            this.price = price;
      }catch(Exception e){
        System.out.println("invalid price, please try again/n");
      }
    }

    public void setQuantity(int quantity) {
      try{
          if(quantity >= 0)
            this.quantity = quantity;
      }catch(Exception e){
        System.out.println("invalid quantity, please try again/n");
      }
    }

    //acquire lock
    public void acquireLock() {
      synchronized (lock) {
        //lock acquired
      }
    }

    //release lock
    public void releaseLock() {
      synchronized (lock) {
        //Lock released
      }
    }

  }//end of Item object

  class Inventory{
    private Map<String, Item> items; //create map Items made up of Names and Items

    public Inventory(){
      this.items = new HashMap<>(); //use HashMap as data structure
    }

    //add item to the inventory
    public void addItem(String name, double price, int quantity){
      Item itm = new Item(name, price, quantity);
      items.put(name, itm);
    }

    //remove item from the Inventory
    public void removeItem(String name) { //we only need the map's name/key
      if(items.containsKey(name)){
        items.remove(name);
      }else{
        System.out.println("Item not in Inventory");
      }
    }

    //update item quantity in the Inventory
    public void updateItemQuantity(String name, int quantity){
      //must check if item exists
      if(items.containsKey(name)) {
        Item itm = items.get(name);
        itm.acquireLock();//acquire lock before altering map
        itm.setQuantity(quantity); //modify inventory map
        itm.releaseLock();//release lock
        //items.get(name).setQuantity(quantity);
      }else{
        System.out.println("Item not found in Inventory");
      }
    }

    //update item price in the Inventory
    public void updateItemPrice(String name, double price){
      if(items.containsKey(name)){
        Item itm = items.get(name);
        itm.acquireLock();//acquire lock before altering map
        itm.setPrice(price); //modify inventory map
        itm.releaseLock();//release lock
      }else{
          System.out.println("Item not found in Inventory");
      }
    }

    //display items in Inventory
    public void displayInventory() {
      System.out.println("Items in Inventory:\n");
      for(Item item : items.values()) {
        System.out.println(item.getName() + " - Price: $" + item.getPrice() + " - Quantity: " + item.getQuantity());
      }
    }
  }//end of Inventory object
}//end of class
