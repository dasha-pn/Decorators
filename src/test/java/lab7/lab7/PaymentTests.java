package lab7.lab7;

import org.junit.jupiter.api.Test;

import lab7.lab7.payment.CreditCardPaymentStrategy;
import lab7.lab7.payment.PayPalPaymentStrategy;
import lab7.lab7.payment.Payment;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTests {
    @Test
    void creditCard_ok() {
        Payment p = new CreditCardPaymentStrategy("4111111111111111", "Tester");
        assertTrue(p.pay(199.99));
    }
    @Test
    void paypal_ok() {
        Payment p = new PayPalPaymentStrategy("tester@example.com");
        assertTrue(p.pay(0.0));
    }
    @Test
    void creditCard_fail_when_empty() {
        Payment p = new CreditCardPaymentStrategy("", "NoName");
        assertFalse(p.pay(10));
    }
}
