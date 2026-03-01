package org.example;

public class DebitCardPaymentService implements PaymentService{
    @Override
    public void pay(double amount){
        System.out.println("payment of Rs."+amount+" was made using Debit Card!!!");
    }
}

