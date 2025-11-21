package lab7.lab7.delivery;

import java.util.List;
import lab7.lab7.repository.item.Item;

public interface Delivery {
    boolean deliver(List<Item> items);
}
