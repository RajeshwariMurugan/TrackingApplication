package src;

import java.time.LocalDate;

import java.util.List;

public class TaskManager {
	private List<Task> tasks;
	private int nextId = 1;

	public TaskManager() {
		tasks = FileStorage.loadTasks();
		if (!tasks.isEmpty()) {
			nextId = tasks.get(tasks.size() - 1).getId() + 1;
		}
	}

	public void addTask(String title, String description, LocalDate dueDate) {
		Task task = new Task(nextId++, title, description, dueDate);
		tasks.add(task);
		System.out.println("Task added.");
	}

	public void listTasks() {
		if (tasks.isEmpty()) {
			System.out.println("No tasks.");
			return;
		}
		for (Task t : tasks) {
			System.out.println(t);
		}
	}

	public void markComplete(int id) {
		for (Task t : tasks) {
			if (t.getId() == id) {
				t.setCompleted(true);
				System.out.println("Task marked as completed.");
				return;
			}
		}
		System.out.println("Task ID not found.");
	}

	public void deleteTask(int id) {
		tasks.removeIf(t -> t.getId() == id);
		System.out.println("Task deleted (if ID existed).");
	}

	public void save() {
		FileStorage.saveTasks(tasks);
		System.out.println("Tasks saved.");
	}
}
