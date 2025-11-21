package lab7.lab7.payment;

public class CreditCardPaymentStrategy implements Payment {
    private final String cardNumber;
    private final String holder;

    public CreditCardPaymentStrategy(String cardNumber, String holder) {
        this.cardNumber = cardNumber;
        this.holder = holder;
    }

    @Override
    public boolean pay(double price) {
        return price >= 0 && cardNumber != null && !cardNumber.isBlank()
               && holder != null && !holder.isBlank();
    }
}
