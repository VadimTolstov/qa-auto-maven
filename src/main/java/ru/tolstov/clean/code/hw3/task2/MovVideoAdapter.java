package ru.tolstov.clean.code.hw3.task2;

public class MovVideoAdapter implements VideoAdapter {
    @Override
    public String getSupportedExtension() {
        return "mov";
    }

    @Override
    public MP4Video convert(Video video) {
        if (!(video instanceof MovVideo)) {
            throw new IllegalArgumentException("Video object is not an MOV video");
        }
        return new MP4Video(video.getId(), video.getPath());
    }
}
