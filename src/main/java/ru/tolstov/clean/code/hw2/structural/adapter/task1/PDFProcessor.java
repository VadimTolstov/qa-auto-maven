package ru.tolstov.clean.code.hw2.structural.adapter.task1;

public class PDFProcessor {
    private final String pdfContent;

    public PDFProcessor(String pdfContent) {
        this.pdfContent = pdfContent;
    }

    public void processPDF() {
        System.out.println("Обработка PDF..." + pdfContent);
    }

    public String extractText() {
        return "Конвертированный текст из PDF: " + pdfContent;
    }
}
