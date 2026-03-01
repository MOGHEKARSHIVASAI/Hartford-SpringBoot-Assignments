package org.example;

public class UpiPayementService implements PaymentService{
    @Override
    public void pay(double amount){
        System.out.println("payment of Rs."+amount+" was made using UPI payment!!!");
    }
}
