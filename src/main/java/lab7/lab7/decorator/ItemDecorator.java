package lab7.lab7.decorator;

import lab7.lab7.repository.item.Item;

public abstract class ItemDecorator extends Item {
    protected final Item item;

    protected ItemDecorator(Item item) {
        this.item = item;
    }

    @Override
    public String getDescription() {
        return item.getDescription();
    }

    @Override
    public double price() {
        return item.price();
    }
}
