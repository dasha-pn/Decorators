package lab7.lab7.repository.item;

public class CactusFlower extends Item {

    public CactusFlower() {
        this.description = "Cactus flower";
    }

    @Override
    public double price() {
        return 50;
    }
}