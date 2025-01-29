package MovieManagementSystem;

class MovieNode {
    // Attributes 
    // Movie Title, Director, Year of Release, and Rating. 
    private String movieTitle;
    private String director;
    private int yearOfRelease;
    private double rating; // Rating out of 10
    public MovieNode nextNode, previouNode;

    // Constructor 
    MovieNode(String movieTitle, String director, int yearOfRelease, double rating) {
        this.movieTitle = movieTitle;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.nextNode = null;
        this.previouNode = null;
    }

    // Method to display the data in the node 
    public void displayMovieData() {
        System.out.println("Movie Title: " + movieTitle);
        System.out.println("Director: " + director);
        System.out.println("Year of Release: " + yearOfRelease);
        System.out.println("Rating(Out of 10): " + rating);
    }

    // Getters and setter
    public String getDirector() {
        return director;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public double getRating() {
        return rating;
    }
    
    public void setRating(double rating) {
        this.rating = rating;
    }
}

public class DoublyLinkedList {
    // Attributes 
    private MovieNode headNode;
    private MovieNode tailNode;

    // Constructor 
    DoublyLinkedList() {
        this.headNode = null;
        this.tailNode = null;
    } 
    
    // Method to add a node on the start of the doubly linked list
    public void addMovieAtStart(String movieTitle, String director, int yearOfRelease, double rating) {
        // Initializing a new movie-node 
        MovieNode movieNode = new MovieNode(movieTitle, director, yearOfRelease, rating);

        // Checking if the linked list is empty 
        if (headNode == null) {
            headNode = movieNode;
            tailNode = movieNode;
            return;
        }

        // If the Linked list is not empty 
        movieNode.nextNode = headNode;
        headNode.previouNode = movieNode;
        headNode = movieNode;
    }

    // Method to add a node on the end of the doubly linked list
    public void addMovieAtEnd(String movieTitle, String director, int yearOfRelease, double rating) {
        // Initializing a new movie-node 
        MovieNode movieNode = new MovieNode(movieTitle, director, yearOfRelease, rating);

        // Checking if the linked list is empty 
        if (headNode == null) {
            headNode = movieNode;
            tailNode = movieNode;
            return;
        }

        // If the Linked list is not empty 
        tailNode.nextNode = movieNode;
        movieNode.previouNode = tailNode;
        tailNode = movieNode;
    }
    
    // Method to add a node int the middle of the doubly linked list
    public void addMovieInMiddle(String movieTitle, String director, int yearOfRelease, double rating, int place) {
        MovieNode movieNode = new MovieNode(movieTitle, director, yearOfRelease, rating);
        
        // Checking if the index is invalid
        if (place < 0) {
            System.out.println("Index can't be negative.");
            return;
        }

        // Checking if the index is 0 
        if (place == 0) {
            addMovieAtStart(movieTitle, director, yearOfRelease, rating);
            return;
        }

        // Checking if the linked list is empty
        if (headNode == null) {
            headNode = movieNode;
            tailNode = movieNode;
            return;
        }

        // If the linkedlist has elements and index is valid
        int index = 0;
        MovieNode tempNode = headNode;
        while (tempNode != null) {
            if (index == place - 1) {
                movieNode.nextNode = tempNode.nextNode; 
                tempNode.nextNode.previouNode = movieNode;
                movieNode.previouNode = tempNode;
                tempNode.nextNode = movieNode;
                return;
            }
            index++;
            tempNode = tempNode.nextNode;
        }
        System.out.println("The place doesn't exits.");
    }

    // Method to remove a movie Node from the doubly linked list (by Movie Title)
    public void removeMovieRecord(String movieTitle) {
        // Checking if the element lies in the start or the end of the linklist 
        if (headNode.getMovieTitle() == movieTitle) {
            headNode = headNode.nextNode;
            headNode.previouNode = null;
            System.out.println("Movie record deleted."); 
            return;
        }
        else if (tailNode.getMovieTitle() == movieTitle) {
            tailNode = tailNode.previouNode;
            tailNode.nextNode = null;
            System.out.println("Movie record deleted."); 
            return;
        }
        
        // If the movie lies in the middle of the linked list 
        MovieNode tempNode = headNode;
        while (tempNode != null) {
            if (tempNode.getMovieTitle() == movieTitle) {
                tempNode.previouNode.nextNode = tempNode.nextNode;
                tempNode.nextNode.previouNode = tempNode.previouNode;
                System.out.println("Movie record deleted."); 
                return;
            }
            tempNode = tempNode.nextNode;
        }
        System.out.println("Movie not found!");
    }

    // Method to search movie record by director name and rating
    public void searchMovie(String director, double rating) {
        MovieNode tempNode = headNode;
        while (tempNode != null) {
            if (tempNode.getDirector() == director && tempNode.getRating() == rating) {
                tempNode.displayMovieData();
                return;
            }
            tempNode = tempNode.nextNode;
        }
        System.out.println("Movie not found!");
    }
    
    // Method to traverse the doubly linked list from the start
    public void displayMoviesFromStart() {
        // Checking if the linked list is empty 
        if (headNode == null) {
            System.out.println("The list is empty");
            return;
        }

        MovieNode tempNode = headNode; 
        while (tempNode != null) { //Iterating from the start to the end 
            tempNode.displayMovieData();
            System.out.println();
            tempNode = tempNode.nextNode;
        }
    } 

    // Method to traverse the doubly linked list from the end
    public void displayMoviesFromEnd() {
        // Checking if the linked list is empty 
        if (headNode == null) {
            System.out.println("The list is empty");
            return;
        }

        MovieNode tempNode = tailNode; 
        while (tempNode != null) { //Iterating from the end to the start 
            tempNode.displayMovieData();
            System.out.println();
            tempNode = tempNode.previouNode;
        }
    } 
    
    // Method to update the movie rating with the help of movie title
    public void updateMovieRating(String movieTitle, double rating) {
        // Checking if the linked list is empty 
        if (headNode == null) {
            System.out.println("The list is empty");
            return;
        }

        MovieNode tempNode = headNode;
        while (tempNode != null) {
            if (tempNode.getMovieTitle() == movieTitle) {
                tempNode.setRating(rating);
                System.out.println("Rating updated successfully.");
                return;
            }
            tempNode = tempNode.nextNode;
        }
        System.out.println("Movie not found!");
    }  
}
