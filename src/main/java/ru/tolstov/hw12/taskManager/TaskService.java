package ru.tolstov.hw12.taskManager;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TaskService<T> {
    private final Set<Task<T>> tasks = ConcurrentHashMap.newKeySet();

    public void add(Task<T> task) {
        Objects.requireNonNull(task, "task must not be null");
        tasks.add(task);
    }

    public synchronized boolean remove(T id) {
        Objects.requireNonNull(id, "id must not be null");
        return tasks.remove(new Task<>(id, Status.Backlog, Priority.Critical, new Date(0)));
    }

    public Set<Task<T>> getTasksByStatusAndPriority(Status status, Priority priority) {
        Objects.requireNonNull(status, "status must not be null");
        Objects.requireNonNull(priority, "priority must not be null");
        return Set.copyOf(
                tasks.stream()
                        .filter(task -> status.equals(task.getStatus()) && priority.equals(task.getPriority()))
                        .collect(Collectors.toSet()));
    }

    public Set<Task<T>> getTasksSortedByDateAsc() {
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getDate))
                .collect(Collectors.toCollection(LinkedHashSet::new)
                );
    }

    public Set<Task<T>> getTasksSortedByDateDesc() {
        return tasks.stream()
                .sorted((x, y) -> y.getDate().compareTo(x.getDate()))
                .collect(Collectors.toCollection(LinkedHashSet::new)
                );
    }

    public Set<Task<T>> getTasksByStatus(Status status) {
        Objects.requireNonNull(status, "status must not be null");
        return Set.copyOf(
                tasks.stream()
                        .filter(task -> status.equals(task.getStatus()))
                        .collect(Collectors.toSet()));
    }

    public Set<Task<T>> getTasksByPriority(Priority priority) {
        Objects.requireNonNull(priority, "priority must not be null");
        return Set.copyOf(
                tasks.stream()
                        .filter(task -> priority.equals(task.getPriority()))
                        .collect(Collectors.toSet()));
    }
}
