package ru.tolstov.clean.code.hw3.task2;

public class MP4Video extends Video {

    public MP4Video(int id, String path) {
        super(id, path);
    }

    @Override
   public void load() {
        System.out.println("MP4Video loaded");
    }
}
