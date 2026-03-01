package org.example;

public class UPIPaymentService implements PaymentService{
    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount + " completed via UPI");
    }
}
