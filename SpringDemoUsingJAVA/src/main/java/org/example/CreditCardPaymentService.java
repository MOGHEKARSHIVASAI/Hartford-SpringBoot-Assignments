package org.example;

public class CreditCardPaymentService implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount + " completed via Credit Card");
    }
}

