package LibraryManagementSystem;

public class Main {
    public static void main(String[] args) {
        // Initilalizing the linked list 
        LibraryManagement library = new LibraryManagement();

        // Adding books to the library linked list 
        library.addAtEnd("The Great Gatsby", "F. Scott Fitzgerald", "Classic", 101, true);
        library.addAtBeginning("1984", "George Orwell", "Dystopian", 102, true);
        library.addAtEnd("To Kill a Mockingbird", "Harper Lee", "Fiction", 103, false);
        library.addAtPosition("Moby Dick", "Herman Melville", "Adventure", 104, true, 2);

        // Forward order 
        System.out.println("Library Books (Forward Order):");
        library.displayForward();
        
        // Reverse order 
        System.out.println("\nLibrary Books (Reverse Order):");
        library.displayReverse();
        
        // Removing the element from the list  
        library.removeBook(103);
        System.out.println("\nLibrary after removing a book:");
        library.displayForward();
        
        // Updating the availabilty of the book 
        library.updateAvailability(104, false);
        System.out.println("\nLibrary after updating availability:");
        library.displayForward();

        // Searching a book by title 
        System.out.println("\nSearching for '1984':");
        library.searchByTitle("1984");
        
        // Searching a book by author
        System.out.println("\nSearching for books by George Orwell:");
        library.searchByAuthor("George Orwell");
        
        // Counting the total nuber of books 
        library.countBooks();
    }
}
