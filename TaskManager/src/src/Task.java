package src;

import java.time.LocalDate;

public class Task   {
    private int id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;

    public Task(int id, String title, String description, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDate getDueDate() { return dueDate; }
    public boolean isCompleted() { return completed; }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String toString() {
        return String.format("ID: %d | %s | Due: %s | Completed: %s",
                id, title, dueDate, completed ? "Yes" : "No");
    }
}
