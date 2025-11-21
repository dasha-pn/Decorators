package lab7.lab7;

import lab7.lab7.decorator.BasketDecorator;
import lab7.lab7.decorator.PaperDecorator;
import lab7.lab7.decorator.RibbonDecorator;
import lab7.lab7.repository.item.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoratorsTests {

    static class BaseItem extends Item {
        BaseItem() { this.description = "Base"; }
        @Override public double price() { return 100.0; }
    }

    @Test
    void paper_adds_13() {
        Item item = new PaperDecorator(new BaseItem());
        assertEquals(113.0, item.price(), 1e-9);
        assertTrue(item.getDescription().contains("paper"));
    }

    @Test
    void ribbon_adds_40() {
        Item item = new RibbonDecorator(new BaseItem());
        assertEquals(140.0, item.price(), 1e-9);
        assertTrue(item.getDescription().contains("ribbon"));
    }

    @Test
    void basket_adds_4() {
        Item item = new BasketDecorator(new BaseItem());
        assertEquals(104.0, item.price(), 1e-9);
        assertTrue(item.getDescription().contains("basket"));
    }

    @Test
    void combined_decorators_sum_prices_and_descriptions() {
        Item item = new BasketDecorator(
                        new RibbonDecorator(
                            new PaperDecorator(new BaseItem())));
        assertEquals(100.0 + 13.0 + 40.0 + 4.0, item.price(), 1e-9);
        String d = item.getDescription();
        assertTrue(d.contains("paper"));
        assertTrue(d.contains("ribbon"));
        assertTrue(d.contains("basket"));
    }
}
