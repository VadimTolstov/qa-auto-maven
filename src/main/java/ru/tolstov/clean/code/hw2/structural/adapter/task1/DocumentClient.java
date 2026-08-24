package ru.tolstov.clean.code.hw2.structural.adapter.task1;

public class DocumentClient {
    private final DocumentProcessor docProcessor;

    public DocumentClient(DocumentProcessor docProcessor) {
        this.docProcessor = docProcessor;
    }

    public String run() {
        String result = docProcessor.process();
        System.out.println("Клиент получил результат: " + result);
        return result;
    }
}
