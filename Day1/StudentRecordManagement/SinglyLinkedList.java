package StudentRecordManagement;

class StudentNode {
    // Attributes
    private int rollNumber;
    private String name;
    private int age;
    private char grade;
    public StudentNode nextNode; // next node

    //Constructor
    public StudentNode(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.nextNode = null;
    }

    // Method to display the details of the ndoe
    public void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }

    // Getters and setters 
    public int getRollNumber() {
        return rollNumber;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
}

public class SinglyLinkedList {
    // Attributes
    StudentNode headNode;

    // Constructor
    public SinglyLinkedList() {
        headNode = null;
    }

    // Method to add an element in the start
    public void addStudentOnStart(int rollNumber, String name, int age, char grade) {
        StudentNode studentNode = new StudentNode(rollNumber, name, age, grade);

        // Checking if the linked list is empty
        if (headNode == null) {
            headNode = studentNode;
            return;
        }

        // if some element exits at the top then
        studentNode.nextNode = headNode;
        headNode = studentNode;
    }

    // Method to add an element in the last
    public void addStudentOnEnd(int rollNumber, String name, int age, char grade) {
        StudentNode studentNode = new StudentNode(rollNumber, name, age, grade);

        // Checking if the linked list is empty
        if (headNode == null) {
            headNode = studentNode;
            return;
        }

        // If the linked list has elements, then iterating to the last element and assing its next ehe value of studentNode
        StudentNode tempNode = headNode;
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = studentNode;
    }

    // Method to add an element in the middle
    public void addStudentOnMiddle(int rollNumber, String name, int age, char grade, int place) {
        StudentNode studentNode = new StudentNode(rollNumber, name, age, grade);

        // Checking if the index is positive
        if (place < 0) {
            System.out.println("Index can't be negative.");
        }
        else if (place == 0) {
            addStudentOnStart(rollNumber, name, age, grade);
            return;
        }

        // Checking if the linked list is empty
        if (headNode == null) {
            headNode = studentNode;
            return;
        }

        // If the linkedlist has elements and index is valid
        int index = 0;
        StudentNode tempNode = headNode;
        while (tempNode != null) {
            if (index == place - 1) {
                studentNode.nextNode = tempNode.nextNode;
                tempNode.nextNode = studentNode;
                return;
            }
            index++;
            tempNode = tempNode.nextNode;
        }
        System.out.println("The place doesn't exits.");
    }

    // Method to display all student record
    public void displayRecords() {
        StudentNode tempNode = headNode;
        while (tempNode != null) {
            tempNode.displayDetails();
            System.out.println();
            tempNode = tempNode.nextNode;
        }
    }
    
    // Method to search a Student with its rollNumber 
    public void searchStudentRecords(int rollNumber) {
        StudentNode tempNode = headNode;
        while (tempNode != null) {
            if (tempNode.getRollNumber() == rollNumber) {
                tempNode.displayDetails();
                return;
            }
            tempNode = tempNode.nextNode;
        }
        System.out.println("Roll Number doesn't exists.");
    }

    // Method delete the Student Node with rollNumber 
    public void deleteStudentRecord(int rollNumber) {
        // Checking if the element is at the headnode 
        if (headNode.getRollNumber() == rollNumber) {
            headNode = headNode.nextNode;
            return;
        }
        
        StudentNode tempNode = headNode;
        StudentNode previousTemp = headNode;
        while (tempNode != null) {
            if (tempNode.getRollNumber() == rollNumber) {
                previousTemp.nextNode = tempNode.nextNode;
                return;
            }
            previousTemp = tempNode;
            tempNode = tempNode.nextNode;
        }
        System.out.println("Roll-Number not found.");
    }
    
    // Method to update student grade based on there rollnumber 
    public void updateGrade(int rollNumber, char grade) {
        StudentNode tempNode = headNode;

        while (tempNode != null) {
            if (tempNode.getRollNumber() == rollNumber) {
                tempNode.setGrade(grade);
                return;
            }
            tempNode = tempNode.nextNode;
        }

        System.out.println("Roll-Number not found.");
    }
}