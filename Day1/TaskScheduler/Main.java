package TaskScheduler;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList scheduler = new CircularLinkedList();

        scheduler.addAtEnd(101, "Task A", 2, "2025-02-01");
        scheduler.addAtBeginning(102, "Task B", 1, "2025-01-15");
        scheduler.addAtEnd(103, "Task C", 3, "2025-03-10");
        scheduler.addAtPosition(104, "Task D", 2, "2025-02-20", 2);

        System.out.println("All tasks:");
        scheduler.displayTasks();

        scheduler.removeTask(103);
        System.out.println("Tasks after deletion:");
        scheduler.displayTasks();

        System.out.println("\nSearching for tasks with priority 2:");
        scheduler.searchByPriority(2);

        System.out.println("\nCurrent and next tasks:");
        scheduler.viewAndMoveToNextTask();
        scheduler.viewAndMoveToNextTask();
    }
}
