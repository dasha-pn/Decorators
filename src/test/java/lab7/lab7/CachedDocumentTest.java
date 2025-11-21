package lab7.lab7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab7.lab7.decorator.CachedDocument;
import lab7.lab7.decorator.Document;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CachedDocumentTest {

    static class CountingDocument implements Document {
        int calls = 0;
        final String base;

        CountingDocument(String base) {
            this.base = base;
        }

        @Override
        public String parse() {
            calls++;
            return base + "#" + calls;
        }
    }

    @BeforeEach
    void cleanDb() throws Exception {
        Files.deleteIfExists(Path.of("cache.db"));
    }

    @Test
    void cachedDocumentCallsWrappedOnlyOnce() {
        CountingDocument inner = new CountingDocument("DATA");

        CachedDocument cached = new CachedDocument(inner, "key1");

        String first = cached.parse();
        String second = cached.parse();

        assertEquals(first, second);
        assertEquals(1, inner.calls);
    }

    @Test
    void cacheIsSharedBetweenInstancesWithSameKey() {
        CountingDocument producer = new CountingDocument("DATA");
        CachedDocument cached1 = new CachedDocument(producer, "same-key");

        String first = cached1.parse();
        assertEquals(1, producer.calls);

        CountingDocument consumer = new CountingDocument("OTHER");
        CachedDocument cached2 = new CachedDocument(consumer, "same-key");

        String second = cached2.parse();

        assertEquals(first, second);
        assertEquals(0, consumer.calls);
    }
}
