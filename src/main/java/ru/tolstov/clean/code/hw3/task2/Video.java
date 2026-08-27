package ru.tolstov.clean.code.hw3.task2;

public abstract class Video {
    private int id;
    private String path;

    public Video(int id, String path) {
        this.id = id;
        this.path = path;
    }

    public abstract void load();

    public int getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", path='" + path + '\'' +
                '}';
    }
}
