package org.example;

public class DebitCardPaymentService implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount + " completed via Debit Card");
    }
}
