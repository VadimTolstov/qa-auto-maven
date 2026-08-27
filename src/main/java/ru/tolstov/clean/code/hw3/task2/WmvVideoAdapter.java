package ru.tolstov.clean.code.hw3.task2;

public class WmvVideoAdapter implements VideoAdapter {
    @Override
    public String getSupportedExtension() {
        return "wmv";
    }

    @Override
    public MP4Video convert(Video video) {
        if (!(video instanceof WmvVideo)) {
            throw new IllegalArgumentException("Video object is not an WMV video");
        }
        return new MP4Video(video.getId(), video.getPath());
    }
}
