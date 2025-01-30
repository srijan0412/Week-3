package OnlineTicketReservationSystem;

class TicketNode {
    // Attributes 
    private String ticketId;
    private String customerName;
    private String movieName;
    private String seatNumber;
    private String bookingTime;
    public TicketNode nextNode;

    // Constructor 
    public TicketNode(String ticketId, String customerName, String movieName, String seatNumber, String booktingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = booktingTime;
        this.nextNode = null;
    }

    // Method to display Ticket details 
    public void displayDetails() {
        System.out.println("Ticket Id: " + ticketId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Booking Time: " + bookingTime);
    }

    // Getter and setter 
    public String getTicketId() {
        return ticketId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getMovieName() {
        return movieName;
    }
}

public class OnlineTicketReservationSystem {
    // Attributes 
    TicketNode head;
    TicketNode tail;

    // Constructor 
    public OnlineTicketReservationSystem() {
        this.head = null;
        this.tail = null;
    }

    // Method to add a new ticket at the end of the circular list 
    public void addTicket(String ticketId, String customerName, String movieName, String seatNumber, String booktingTime) {
        TicketNode ticketNode = new TicketNode(ticketId, customerName, movieName, seatNumber, booktingTime);
        
        // Checking if the list is empty 
        if (head == null) {
            tail = ticketNode;
            head = ticketNode;
            head.nextNode = head; // Circular behavious 
            return;
        }

        tail.nextNode = ticketNode;
        tail = ticketNode;
        tail.nextNode = head;
    }

    // Method to remove a ticket by ticketId
    public void removeTicket(String ticketId) {
        // Checking if the list is empty 
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        // Checking if it is the first ticket 
        if (head.getTicketId() == ticketId) {
            head = head.nextNode;
            tail.nextNode = head;
        }

        TicketNode temp = head, prev = null;
        do {
            if (temp.getTicketId() == ticketId) {
                prev.nextNode = temp.nextNode;
                temp.nextNode = null;
                return;
            }
            prev = temp;
            temp = temp.nextNode;
        }
        while (temp.getTicketId() != head.getTicketId());
        System.out.println("Ticket Id: " + ticketId + " not found!!");
    }

    // Method to display the current tickets 
    public void displayDetails() {
        // Checking if the list is empty 
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        TicketNode temp = head;

        do {
            temp.displayDetails();
            System.out.println();
            temp = temp.nextNode;
        }
        while (temp != head);
    }
    
    // Method to search a ticket by customerName 
    public void searchTicketWithCustomerName(String customerName) {
        // Checking if the list is empty 
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        TicketNode temp = head;
        do {
            if (temp.getCustomerName() == customerName) {
                temp.displayDetails();
                return;
            }
            temp = temp.nextNode;
        }
        while (temp != head);
        System.out.println("Customer Name not found!");
    }

    // Method to search a ticket by movieName 
    public void searchTicketWithMovieName(String movieName) {
        // Checking if the list is empty 
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.println("Searching for all the records with movie name: " + movieName);
        TicketNode temp = head;
        do {
            if (temp.getMovieName() == movieName) {
                temp.displayDetails();
                System.out.println();
            }
            temp = temp.nextNode;
        }
        while (temp != head);
        System.out.println("These are the records found!");
    }

    // Method to calculate the total number of booked tickets  
    public void calculateTotalTickets() {
        // Checking if the list is empty 
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        // Counting the number of ticket nodes in the list 
        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.nextNode;
        }
        while (temp != head);

        // Output 
        System.out.println("Total tickets are " + count);
    }
}
