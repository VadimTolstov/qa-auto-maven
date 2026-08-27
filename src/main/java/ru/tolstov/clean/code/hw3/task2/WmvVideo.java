package ru.tolstov.clean.code.hw3.task2;

public class WmvVideo extends Video {
    public WmvVideo(int id, String path) {
        super(id, path);
    }

    @Override
    public void load() {
        System.out.println("WMV video loaded");
    }
}
