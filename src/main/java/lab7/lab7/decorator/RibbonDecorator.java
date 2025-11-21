package lab7.lab7.decorator;

import lab7.lab7.repository.item.Item;

public class RibbonDecorator extends ItemDecorator {
    public RibbonDecorator(Item item) { super(item); }

    @Override public double price() { 
        return 40 + item.price(); 
    }

    @Override public String getDescription() { 
        return super.getDescription() + " + ribbon"; 
    }
}
