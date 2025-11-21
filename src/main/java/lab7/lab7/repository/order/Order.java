package lab7.lab7.repository.order;

import java.util.LinkedList;
import java.util.List;

import lab7.lab7.delivery.Delivery;
import lab7.lab7.payment.Payment;
import lab7.lab7.repository.item.Item;

public class Order {
    private final LinkedList<Item> items = new LinkedList<>();
    private Payment payment;
    private Delivery delivery;

    public void setPaymentStrategy(Payment payment) { this.payment = payment; }
    public void setDeliveryStrategy(Delivery delivery) { this.delivery = delivery; }

    public void addItem(Item item) { items.add(item); }
    public void removeItem(Item item) { items.remove(item); }

    public double calculateTotalPrice() {
        return items.stream().mapToDouble(Item::price).sum();
    }

    public boolean processOrder() {
        if (payment == null || delivery == null)
            throw new IllegalStateException("Payment/Delivery strategy not set");
        double total = calculateTotalPrice();
        boolean paid = payment.pay(total);
        return paid && delivery.deliver(items);
    }

    public List<Item> getItems() { return List.copyOf(items); }
}
