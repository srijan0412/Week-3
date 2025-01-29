package RoundRobinSchedulingAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

class ProcessNode {
    // Attributes 
    int processId;
    int burstTime;
    int priority;
    ProcessNode next;

    // Constructor 
    ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

public class RoundRobinScheduler {
    // Attributes 
    private ProcessNode head;
    private ProcessNode tail;

    // Constructor 
    RoundRobinScheduler() {
        this.head = null;
        this.tail = null;
    }

    // Method to add a process at the end of the circular list
    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(processId, burstTime, priority);
        // Checking if the Linkedlist is empty 
        if (head == null) {
            head = tail = newNode;
            tail.next = head; // Circular link
            return;
        } 
        
        // if the linked list has elements 
        tail.next = newNode;
        tail = newNode;
        tail.next = head; // Maintain circular nature
    }

    // Method to remove a process by Process ID
    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        ProcessNode temp = head, prev = null;
        boolean found = false;

        do {
            if (temp.processId == processId) {
                found = true;
                break;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("Process ID " + processId + " not found.");
            return;
        }

        if (temp == head && temp == tail) { // Only one node in the list
            head = tail = null;
        } 
        else if (temp == head) { // Removing head node
            head = head.next;
            tail.next = head;
        } 
        else if (temp == tail) { // Removing tail node
            prev.next = head;
            tail = prev;
        } 
        else { // Removing a middle node
            prev.next = temp.next;
        }

        System.out.println("Process ID " + processId + " removed.");
    }

    // Method to display the list of processes
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        ProcessNode temp = head;
        System.out.println("Processes in the queue:");
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    // Method to simulate round-robin scheduling
    public void simulateRoundRobin(int timeQuantum) {
        // Checking if the list is empty 
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        // if list is not empty 
        int totalProcesses = 0;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        Queue<Integer> completionOrder = new LinkedList<>();

        ProcessNode current = head;
        int elapsedTime = 0;

        while (head != null) {
            if (current.burstTime > 0) {
                int executionTime = Math.min(current.burstTime, timeQuantum);
                elapsedTime += executionTime;
                current.burstTime -= executionTime;

                System.out.println("Executing Process ID: " + current.processId + " for " + executionTime + " units.");

                if (current.burstTime == 0) {
                    System.out.println("Process ID " + current.processId + " completed.");
                    completionOrder.add(current.processId);

                    totalProcesses++;
                    totalTurnaroundTime += elapsedTime;
                    totalWaitingTime += elapsedTime - executionTime;
                    
                    removeProcess(current.processId);
                }
            }
            current = (head != null) ? current.next : null; // Move to next process
        }

        // Display process completion order
        System.out.println("\nProcess Completion Order:");
        while (!completionOrder.isEmpty()) {
            System.out.print(completionOrder.poll() + " ");
        }
        System.out.println();

        // Calculate and display average waiting time and turnaround time
        if (totalProcesses > 0) {
            System.out.println("Average Waiting Time: " + (double) totalWaitingTime / totalProcesses);
            System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / totalProcesses);
        }
    }
}
