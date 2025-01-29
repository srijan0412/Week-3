package TaskScheduler;

class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class CircularLinkedList {
    private TaskNode head = null;
    private TaskNode tail = null;
    private TaskNode current = null; // To track the current task

    // Method to add a task at the beginning of the circular list
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head; // Circular connection
        } else {
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
    }

    // Method to add a task at the end of the circular list
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    // Method to add a task at a specific position in the circular list
    public void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (position <= 1 || head == null) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        TaskNode temp = head;
        int count = 1;
        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        if (temp == tail) {
            tail = newNode;
        }
    }

    // Method to remove a task by Task ID
    public void removeTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        TaskNode temp = head, prev = null;

        // If the head node is to be deleted
        if (head.taskId == taskId) {
            if (head == tail) { // Only one node case
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            System.out.println("Task " + taskId + " deleted.");
            return;
        }

        // Traverse the list to find the task
        do {
            prev = temp;
            temp = temp.next;
        } while (temp != head && temp.taskId != taskId);

        if (temp == head) {
            System.out.println("Task " + taskId + " not found.");
            return;
        }

        prev.next = temp.next;
        if (temp == tail) {
            tail = prev;
        }
        System.out.println("Task " + taskId + " deleted.");
    }

    // Method to view the current task and move to the next task
    public void viewAndMoveToNextTask() {
        if (current == null) {
            current = head;
        }
        if (current != null) {
            System.out.println("Current Task: " + current.taskName + " (ID: " + current.taskId + ")");
            current = current.next; // Move to the next task in circular manner
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Method to display all tasks in the circular lis
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName +
                    ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Method to search for tasks by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName +
                        ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }
}
