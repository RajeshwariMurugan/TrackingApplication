package src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {
    private static final String FILE_NAME = "C:\\Users\\Raji\\Desktop\\Backend\\TaskManager\\tasks.txt";

    // Save tasks in text format (CSV-style)
    public static void saveTasks(List<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(task.getId() + "," +
                             escape(task.getTitle()) + "," +
                             escape(task.getDescription()) + "," +
                             task.getDueDate() + "," +
                             task.isCompleted());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    // Load tasks from text file
    public static List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return tasks;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1); // include empty strings
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    String title = unescape(parts[1]);
                    String desc = unescape(parts[2]);
                    java.time.LocalDate dueDate = java.time.LocalDate.parse(parts[3]);
                    boolean completed = Boolean.parseBoolean(parts[4]);
                    Task task = new Task(id, title, desc, dueDate);
                    task.setCompleted(completed);
                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }

        return tasks;
    }

    // Escape commas to avoid breaking CSV structure
    private static String escape(String text) {
        return text.replace(",", "\\,");
    }

    // Unescape commas
    private static String unescape(String text) {
        return text.replace("\\,", ",");
    }
}
