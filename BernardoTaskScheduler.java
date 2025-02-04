import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BernardoTaskScheduler {
    private static List<String> tasks = new ArrayList<>();

    // Function to add a task
    public static void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    // Function to run the scheduler
    public static void runScheduler() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to run.");
            return;
        }

        System.out.println("Running scheduled tasks:");
        for (String task : tasks) {
            System.out.println("Executing: " + task);
        }
        tasks.clear(); // Clear tasks after execution
    }

    // Main function to handle user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            try {
                System.out.println("\n1. Add Task");
                System.out.println("2. Run Scheduler");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input
                    continue;
                }

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter task: ");
                        String task = scanner.nextLine();
                        addTask(task);
                        break;
                    case 2:
                        runScheduler();
                        break;
                    case 3:
                        System.out.println("Exiting Task Scheduler.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine(); // Clear the buffer
            }
        }
    }
}
