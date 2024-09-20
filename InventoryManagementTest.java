import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class InventoryManagementTest {

    public static void main(String[] args) throws InterruptedException {
        // Create an instance of InventoryManagement and its Inventory
        InventoryManagement inventoryManagement = new InventoryManagement();
        InventoryManagement.Inventory inventory = inventoryManagement.new Inventory();

        // Add a sample item to the inventory
        String itemName = "Laptop";
        inventory.addItem(itemName, 999.99, 100);

        // Display the initial inventory
        System.out.println("Initial Inventory:");
        inventory.displayInventory();

        // Create a thread pool with 100000 threads to simulate 100000 concurrent users
        int numUsers = 100000;
        ExecutorService executorService = Executors.newFixedThreadPool(numUsers);

        // Each user will update the quantity of the item in a concurrent manner
        for (int i = 0; i < numUsers; i++) {
            int finalQuantity = i + 1; // New quantity for the item
            System.out.println("thread number: "+finalQuantity);
            executorService.submit(() -> {
                inventory.updateItemQuantity(itemName, finalQuantity);
            });
        }

        // Shutdown the executor and wait for all tasks to complete
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        // Display the inventory after all updates
        System.out.println("Inventory after 100,000 concurrent updates:");
        inventory.displayInventory();
    }
}
