package lab7.lab7.repository.item;

public abstract class Item {
    protected String description = "Item";
    public String getDescription() { return description; }
    public abstract double price();
}
