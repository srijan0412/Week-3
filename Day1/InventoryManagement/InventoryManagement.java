package InventoryManagement;

// Node class representing an item in the inventory
class ItemNode {
    // Attributes 
    String itemName;
    int itemId;
    int quantity;
    double price;
    ItemNode next;

    // Constructor 
    ItemNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManagement {
    private ItemNode head = null;

    // Method to add an item at the beginning of the list
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    // Method to add an item at the end of the list
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }

        ItemNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Method to add an item at a specific position
    public void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        if (position <= 1 || head == null) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }

        ItemNode temp = head;
        int count = 1;
        while (count < position - 1 && temp.next != null) {
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Method to remove an item based on Item ID
    public void removeItem(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item " + itemId + " removed.");
            return;
        }

        ItemNode temp = head, prev = null;
        while (temp != null && temp.itemId != itemId) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Item " + itemId + " not found.");
            return;
        }

        prev.next = temp.next;
        System.out.println("Item " + itemId + " removed.");
    }

    // Method to update the quantity of an item by Item ID
    public void updateQuantity(int itemId, int newQuantity) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated for Item " + itemId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item " + itemId + " not found.");
    }

    // Method to search for an item by Item ID
    public void searchById(int itemId) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item Found: " + temp.itemName + " (ID: " + temp.itemId + "), Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item " + itemId + " not found.");
    }

    // Method to search for an item by Item Name
    public void searchByName(String itemName) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: " + temp.itemName + " (ID: " + temp.itemId + "), Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item " + itemName + " not found.");
    }

    // Method to calculate and display the total value of inventory
    public void calculateTotalValue() {
        double totalValue = 0;
        ItemNode temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: $" + totalValue);
    }

    // Method to sort inventory based on Item Name (Merge Sort)
    public void sortByName() {
        head = mergeSort(head, "name");
    }

    // Method to sort inventory based on Price (Merge Sort)
    public void sortByPrice() {
        head = mergeSort(head, "price");
    }

    // Merge Sort Helper Method
    private ItemNode mergeSort(ItemNode head, String criteria) {
        // if array has no elements or have only one element 
        if (head == null || head.next == null) {
            return head;
        }

        ItemNode middle = getMiddle(head);
        ItemNode nextOfMiddle = middle.next;
        middle.next = null;

        ItemNode left = mergeSort(head, criteria);
        ItemNode right = mergeSort(nextOfMiddle, criteria);

        return merge(left, right, criteria);
    }

    // Find middle node
    private ItemNode getMiddle(ItemNode head) {
        if (head == null) return head;
        ItemNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted lists
    private ItemNode merge(ItemNode left, ItemNode right, String criteria) {
        if (left == null) return right;
        if (right == null) return left;

        if ((criteria.equals("name") && left.itemName.compareToIgnoreCase(right.itemName) < 0) ||
            (criteria.equals("price") && left.price < right.price)) {
            left.next = merge(left.next, right, criteria);
            return left;
        } 
        else {
            right.next = merge(left, right.next, criteria);
            return right;
        }
    }

    // Method to display all inventory items
    public void displayInventory() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }

        ItemNode temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.itemId + ", Name: " + temp.itemName +
                    ", Quantity: " + temp.quantity + ", Price: $" + temp.price);
            temp = temp.next;
        }
    }
}
