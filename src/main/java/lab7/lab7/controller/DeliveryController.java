package lab7.lab7.controller;

import lab7.lab7.delivery.DHLDeliveryStrategy;
import lab7.lab7.delivery.PostDeliveryStrategy;
import lab7.lab7.repository.item.Item;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    public static class SimpleItem extends Item {
        private final double p;

        public SimpleItem(String name, double price) { 
            this.description = name; this.p = price; 
        }
        
        @Override public double price() { 
            return p; 
        }
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/post")
    public String post(@RequestBody List<SimpleItem> items) {
        return new PostDeliveryStrategy().deliver((List<Item>)(List<?>)items) ? "post accepted" : "post rejected";
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/dhl")
    public String dhl(@RequestBody List<SimpleItem> items) {
        return new DHLDeliveryStrategy().deliver((List<Item>)(List<?>)items) ? "dhl accepted" : "dhl rejected";
    }
}
