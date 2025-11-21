package lab7.lab7.decorator;

import lab7.lab7.repository.item.Item;

public class PaperDecorator extends ItemDecorator {
    public PaperDecorator(Item item) { super(item); }

    @Override public double price() { 
        return 13 + item.price(); 
    }

    @Override public String getDescription() { 
        return super.getDescription() + " + paper"; 
    }
}
