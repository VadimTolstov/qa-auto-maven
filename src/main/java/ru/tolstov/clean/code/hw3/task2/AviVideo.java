package ru.tolstov.clean.code.hw3.task2;

public class AviVideo extends Video{
    public AviVideo(int id, String path) {
        super(id, path);
    }

    @Override
    public void load() {
        System.out.println("AVI video loaded");
    }
}
