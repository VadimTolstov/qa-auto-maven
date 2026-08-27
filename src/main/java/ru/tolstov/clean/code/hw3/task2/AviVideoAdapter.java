package ru.tolstov.clean.code.hw3.task2;

public class AviVideoAdapter implements VideoAdapter {
    @Override
    public String getSupportedExtension() {
        return "avi";
    }

    @Override
    public MP4Video convert(Video video) {
        if (!(video instanceof AviVideo)) {
            throw new IllegalArgumentException("Video object is not an AVI video");
        }
        System.out.println("Converting AVI to MP4...");
        return new MP4Video(video.getId(), video.getPath());
    }
}
