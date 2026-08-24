package ru.tolstov.clean.code.hw2.structural.adapter.task1;

public class DocumentAdapter implements DocumentProcessor {
    private final PDFProcessor pdfProcessor;

    public DocumentAdapter(PDFProcessor pdfProcessor) {
        this.pdfProcessor = pdfProcessor;
    }

    @Override
    public String process() {
        String docContent = pdfProcessor.extractText();
        System.out.println("Конвертация PDF -> DOC. Получен текст: " + docContent);
        return docContent;
    }
}
