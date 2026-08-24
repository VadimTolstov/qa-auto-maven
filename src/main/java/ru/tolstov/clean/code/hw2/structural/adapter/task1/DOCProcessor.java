package ru.tolstov.clean.code.hw2.structural.adapter.task1;

public class DOCProcessor implements DocumentProcessor {
    private final String docContent;

    public DOCProcessor(String docContent) {
        this.docContent = docContent;
    }

    @Override
    public String process() {
        System.out.println("Processing DOC file: " + docContent);
        return docContent;
    }
}
