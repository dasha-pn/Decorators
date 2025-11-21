package lab7.lab7;

import org.junit.jupiter.api.Test;

import lab7.lab7.decorator.Document;
import lab7.lab7.decorator.TimedDocument;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TimedDocumentTest {

    static class FakeDocument implements Document {
        int calls = 0;
        final String result;

        FakeDocument(String result) {
            this.result = result;
        }

        @Override
        public String parse() {
            calls++;
            return result;
        }
    }

    @Test
    void timedDocumentDelegatesAndPrintsTime() {
        FakeDocument fake = new FakeDocument("Hello");

        Document timed = new TimedDocument(fake);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        String res;
        try {
            res = timed.parse();
        } finally {
            System.setOut(originalOut);
        }

        assertEquals("Hello", res);
        assertEquals(1, fake.calls);

        String printed = out.toString();
        assertTrue(printed.contains("Parsing") || printed.contains("took"),
                "TimedDocument should print timing info to System.out");
    }
}
