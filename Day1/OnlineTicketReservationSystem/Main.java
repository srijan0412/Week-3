package OnlineTicketReservationSystem;

public class Main {
    public static void main(String[] args) {
        OnlineTicketReservationSystem reservationSystem = new OnlineTicketReservationSystem();

        // Adding some random tickets 
        reservationSystem.addTicket("A101", "Alice", "Titanic", "A01", "3Pm");
        reservationSystem.addTicket("A102", "Bob", "Spiderman", "C02", "3Pm");
        reservationSystem.addTicket("A103", "Paul", "Inception", "C23", "3Pm");
        reservationSystem.addTicket("A104", "David", "Interstellar", "B45", "3Pm");

        // displaying detials of the tickets 
        reservationSystem.displayDetails();

        // Searching the ticket 
        reservationSystem.searchTicketWithCustomerName("Alice");
        reservationSystem.searchTicketWithMovieName("Titanic");

        // Removing a ticket 
        reservationSystem.removeTicket("A102");
        reservationSystem.displayDetails();
    }
}
