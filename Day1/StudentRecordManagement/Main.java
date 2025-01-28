package StudentRecordManagement;
public class Main {
    public static void main(String[] args) {
        // Initializing the list 
        SinglyLinkedList students = new SinglyLinkedList();

        // Adding some Students to the linkedlist 
        students.addStudentOnStart(1, "Alice", 15, 'A');
        students.addStudentOnEnd(2, "Bob", 15, 'B');
        students.addStudentOnEnd(3, "John", 15, 'C');
        students.addStudentOnEnd(4, "Paul", 16, 'A');

        // Updating the grade 
        students.updateGrade(3, 'A');

        // Deleting an element from the students list 
        students.deleteStudentRecord(2);

        // Searching a student record with rollnumber 
        students.searchStudentRecords(1);
        students.searchStudentRecords(2); //Element is deleted so rollnumber doesn't exits

        // Displaying the details 
        students.displayRecords();
    }
}