package RoundRobinSchedulingAlgorithm;

public class Main {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(1, 8, 2);
        scheduler.addProcess(2, 4, 1);
        scheduler.addProcess(3, 9, 3);
        scheduler.addProcess(4, 5, 2);

        System.out.println("Initial Process Queue:");
        scheduler.displayProcesses();

        int timeQuantum = 3;
        System.out.println("\nSimulating Round Robin Scheduling with Time Quantum: " + timeQuantum);
        scheduler.simulateRoundRobin(timeQuantum);
    }
}
