package lab7.lab7.decorator;

public class TimedDocument implements Document {

    private final Document document;

    public TimedDocument(Document document) {
        this.document = document;
    }

    @Override
    public String parse() {
        long start = System.currentTimeMillis();

        String result = document.parse();

        long end = System.currentTimeMillis();
        long duration = end - start;

        System.out.println("Parsing took " + duration + " ms");

        return result;
    }
}
