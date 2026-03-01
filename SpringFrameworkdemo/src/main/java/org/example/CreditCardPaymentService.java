package org.example;

public class CreditCardPaymentService implements PaymentService{
    @Override
    public void pay(double amount){
        System.out.println("payment of Rs."+amount+" was made using Credit Card!!!");
    }
}

