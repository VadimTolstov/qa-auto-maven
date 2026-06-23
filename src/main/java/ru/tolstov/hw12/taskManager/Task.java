package ru.tolstov.hw12.taskManager;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Task<T> {
    private T id;
    private Status status;
    private Priority priority;
    private Date date;

    public Task(T id, Status status, Priority priority, Date date) {
        Objects.requireNonNull(id, "id is null");
        Objects.requireNonNull(status, "status is null");
        Objects.requireNonNull(priority, "priority is null");
        Objects.requireNonNull(date, "date is null");
        this.id = id;
        this.status = status;
        this.priority = priority;
        this.date = truncate(date);
    }

    public T getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public Date getDate() {
        return date;
    }

    public void setId(T id) {
        Objects.requireNonNull(id, "id is null");
        this.id = id;
    }

    public void setStatus(Status status) {
        Objects.requireNonNull(status, "status is null");
        this.status = status;
    }

    public void setPriority(Priority priority) {
        Objects.requireNonNull(priority, "priority is null");
        this.priority = priority;
    }

    public void setDate(Date date) {
        Objects.requireNonNull(date, "date is null");
        this.date = date;

    }

    private static Date truncate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", status=" + status +
                ", priority=" + priority +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task<?> task = (Task<?>) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
