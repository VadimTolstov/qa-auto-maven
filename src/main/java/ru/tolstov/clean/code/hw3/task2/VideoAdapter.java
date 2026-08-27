package ru.tolstov.clean.code.hw3.task2;

public interface VideoAdapter {
    String getSupportedExtension();

    MP4Video convert(Video video);
}
