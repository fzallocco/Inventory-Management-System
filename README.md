
# 1. How to run program

Make sure you have the latest JDK installed
I have Java version 18.0

After cloning this repository, open this folder with your terminal. For Windows, you can choose to open the folder with CMD (Terminal) by right-clicking on it and selecting terminal.

Subsequently, call the Java compiler "javac" and convert the two files into class files that can be read by your machine. Execute the below commands:

javac InventoryManagement.java

javac InventoryManagementTest.java

java InventoryManagementTest

The console will prompt you into the interface that is built upon the Inventory Mangement System API. To exit the console, type -1.

# 2. About the Project

In Parallel Computing, I learned about concurrency and how to work with multithreaded applications. During a conversation I had with an entrepreneur, I noticed how many small businesses with online presence on multiple e-commerce sites have the same problem: their inventory management system fails to update when processing multiple requests from different points of sale. Hence, I developed this solution that leverages Locking mechanism to synchronize requests from multiple users, maintaining data integrity and consistency. The application will execute update requests one by one by first acquiring a lock, performing operations like updateItemQuantity and updateItemPrice, thus preventing reading data before it's been updated, and finally releasing the lock. 

The test file includes a user interface that is still in test mode and more updates will follow featuring an integer-based menu.