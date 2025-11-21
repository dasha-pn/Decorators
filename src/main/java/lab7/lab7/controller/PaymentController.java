package lab7.lab7.controller;

import lab7.lab7.payment.CreditCardPaymentStrategy;
import lab7.lab7.payment.PayPalPaymentStrategy;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @PostMapping("/credit-card")
    public String payByCard(@RequestParam double amount,
                            @RequestParam String cardNumber,
                            @RequestParam String holder) {
        boolean ok = new CreditCardPaymentStrategy(cardNumber, holder).pay(amount);
        return ok ? "paid by credit card" : "payment failed";
    }

    @PostMapping("/paypal")
    public String payByPaypal(@RequestParam double amount,
                              @RequestParam String email) {
        boolean ok = new PayPalPaymentStrategy(email).pay(amount);
        return ok ? "paid by PayPal" : "payment failed";
    }
}
