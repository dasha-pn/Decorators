package lab7.lab7.delivery;

import java.util.List;
import lab7.lab7.repository.item.Item;

public class DHLDeliveryStrategy implements Delivery {
    @Override
    public boolean deliver(List<Item> items) {
        return items != null && items.size() >= 1;
    }
}
