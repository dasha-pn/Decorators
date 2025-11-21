package lab7.lab7.payment;

public class PayPalPaymentStrategy implements Payment {
    private final String email;

    public PayPalPaymentStrategy(String email) {
        this.email = email;
    }

    @Override
    public boolean pay(double price) {
        return price >= 0 && email != null && email.contains("@");
    }
}
