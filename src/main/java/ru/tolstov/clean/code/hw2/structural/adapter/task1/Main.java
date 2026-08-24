package ru.tolstov.clean.code.hw2.structural.adapter.task1;

public class Main {
    public static void main(String[] args) {
        DocumentProcessor documentProcessor = new DOCProcessor("Отчет за 2020 год");
        DocumentClient client1 = new DocumentClient(documentProcessor);
        String docResult = client1.run();

        System.out.println(docResult);

        System.out.println("========================");

        PDFProcessor pdfProcessor = new PDFProcessor("Отчет за 2020 год");
        DocumentProcessor adapter = new DocumentAdapter(pdfProcessor);
        DocumentClient client2 = new DocumentClient(adapter);
        String adapterResult = client2.run();

        System.out.println(adapterResult);
    }
}
