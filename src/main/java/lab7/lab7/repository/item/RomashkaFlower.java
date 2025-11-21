package lab7.lab7.repository.item;

public class RomashkaFlower extends Item {

    public RomashkaFlower() {
        this.description = "Romashka flower";
    }

    @Override
    public double price() {
        return 30;
    }
}
