package MovieManagementSystem;

public class Main {
    public static void main(String[] args) {
        // Initializing a Doubly linked list object 
        DoublyLinkedList movies = new DoublyLinkedList();
        
        // Adding sample movies to the list 
        movies.addMovieAtStart("Movie1", "Bob", 2022, 7);
        movies.addMovieAtEnd("Movie2", "Alice", 2021, 8);
        movies.addMovieAtEnd("Movie3", "John", 2020, 9);
        movies.addMovieAtEnd("Movie4", "Paul", 2019, 9.5);

        // Updating the movie data for Movie4 
        movies.updateMovieRating("Movie4", 8.5);

        // Searching a specific movie 
        movies.searchMovie("Alice", 8);
        
        // Removing the movie record 
        movies.removeMovieRecord("Movie1");

        // Displaying the movie data 
        movies.displayMoviesFromStart();
        movies.displayMoviesFromEnd();
    }
}