package lab7.lab7;

import lab7.lab7.delivery.DHLDeliveryStrategy;
import lab7.lab7.delivery.PostDeliveryStrategy;
import lab7.lab7.repository.item.Item;
import lab7.lab7.delivery.Delivery;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DeliveryTests {
    static class DummyItem extends Item {
        private final double p;
        public DummyItem(String d, double p){ 
            this.description = d; 
            this.p = p; 
        }
        @Override public double price() { return p; }
    }

    @Test
    void post_accepts_non_empty() {
        Delivery d = new PostDeliveryStrategy();
        assertTrue(d.deliver(List.of(new DummyItem("x", 1))));
    }

    @Test
    void dhl_accepts_at_least_one() {
        Delivery d = new DHLDeliveryStrategy();
        assertTrue(d.deliver(List.of(new DummyItem("x", 1))));
    }

    @Test
    void post_rejects_empty() {
        Delivery d = new PostDeliveryStrategy();
        assertFalse(d.deliver(List.of()));
    }
}
