package ru.tolstov.clean.code.hw3.task2;

public class MovVideo extends Video{
    public MovVideo(int id, String path) {
        super(id, path);
    }

    @Override
    public void load() {
        System.out.println("MOV video loaded");
    }
}
