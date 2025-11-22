package lab7.lab7.decorator;

public class CountingDocument implements Document {

    private final Document document;
    private int calls = 0;

    public CountingDocument(Document document) {
        this.document = document;
    }

    @Override
    public String parse() {
        calls++;
        return document.parse();
    }

    public int getCalls() {
        return calls;
    }
}
