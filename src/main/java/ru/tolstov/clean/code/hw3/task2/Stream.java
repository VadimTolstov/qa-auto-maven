package ru.tolstov.clean.code.hw3.task2;

public class Stream {
    private final MP4Video video;

    public Stream(MP4Video video) {
        this.video = video;
    }

    public void play() {
        System.out.println("Streaming MP4 video with ID:  " + video.getId());
    }
}
