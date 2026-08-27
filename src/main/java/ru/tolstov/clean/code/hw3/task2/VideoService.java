package ru.tolstov.clean.code.hw3.task2;

import java.util.HashMap;
import java.util.Map;

public class VideoService {
    private final Map<String, VideoAdapter> adaptersByExtension = new HashMap<>();
    private final Map<Integer, MP4Video> videoStorage = new HashMap<>();
    private int nextIndex = 1;

    public VideoService(VideoAdapter... adapters) {
        for (VideoAdapter adapter : adapters) {
            adaptersByExtension.put(adapter.getSupportedExtension(), adapter);
        }
    }

    public Video uploadVideo(String videoPath) {
        String extension = extractExtension(videoPath);
        VideoAdapter adapter = adaptersByExtension.get(extension);
        if (adapter == null) {
            throw new IllegalArgumentException("Video extension " + extension + " doesn't exist");
        }

        Video sourceVideo = createSourceVideo(extension, nextIndex, videoPath);
        MP4Video mp4Video = adapter.convert(sourceVideo);

        videoStorage.put(mp4Video.getId(), mp4Video);
        nextIndex++;

        return mp4Video;
    }

    public Stream streamVideo(int videoId) {
        MP4Video video = videoStorage.get(videoId);
        if (video == null) {
            throw new IllegalArgumentException("Video id " + videoId + " doesn't exist");
        }
        return new Stream(video);
    }

    private String extractExtension(String videoPath) {
        int dotIndex = videoPath.lastIndexOf('.');
        if (dotIndex == -1) {
            return "";
        }
        return videoPath.substring(dotIndex + 1).toLowerCase();
    }

    private Video createSourceVideo(String extension, int id, String path) {
        return switch (extension) {
            case "avi" -> new AviVideo(id, path);
            case "mov" -> new MovVideo(id, path);
            case "wmv" -> new WmvVideo(id, path);
            default -> throw new IllegalArgumentException("Unknown extension " + extension);
        };
    }
}
