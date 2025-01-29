package InventoryManagement;

public class Main {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        inventory.addAtEnd("Laptop", 101, 5, 750.50);
        inventory.addAtBeginning("Mouse", 102, 10, 20.99);
        inventory.addAtEnd("Keyboard", 103, 8, 45.75);
        inventory.addAtPosition("Monitor", 104, 4, 150.00, 2);

        System.out.println("Initial Inventory:");
        inventory.displayInventory();

        inventory.removeItem(103);
        System.out.println("\nInventory after removing Keyboard:");
        inventory.displayInventory();

        inventory.updateQuantity(104, 6);
        System.out.println("\nInventory after updating Monitor quantity:");
        inventory.displayInventory();

        System.out.println("\nSearching for item with ID 101:");
        inventory.searchById(101);

        System.out.println("\nSearching for item with Name 'Mouse':");
        inventory.searchByName("Mouse");

        inventory.calculateTotalValue();

        inventory.sortByName();
        System.out.println("\nInventory sorted by Name:");
        inventory.displayInventory();

        inventory.sortByPrice();
        System.out.println("\nInventory sorted by Price:");
        inventory.displayInventory();
    }
}
