package src;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager tm = new TaskManager();

        while (true) {
            System.out.println("\n=== Task Manager ===");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark Task Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. Save and Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Due Date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());
                    tm.addTask(title, desc, date);
                    break;
                case 2:
                    tm.listTasks();
                    break;
                case 3:
                    System.out.print("Enter Task ID to mark complete: ");
                    int compId = sc.nextInt();
                    tm.markComplete(compId);
                    break;
                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int delId = sc.nextInt();
                    tm.deleteTask(delId);
                    break;
                case 5:
                    tm.save();
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
