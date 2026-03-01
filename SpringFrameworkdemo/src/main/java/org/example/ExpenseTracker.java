package org.example;

public class ExpenseTracker {
    private PaymentService ps;

    public ExpenseTracker(PaymentService ps) {
        this.ps = ps;
    }

    public ExpenseTracker() {
    }

    public void setPs(PaymentService ps) {
        this.ps = ps;
    }
    public void payRent(double amount){
        System.out.println("Rent amount is Rs."+amount);
        ps.pay(amount);
    }
    public void rechargeMobile(double amount){
        System.out.println("Recharge amount is Rs."+amount);
        ps.pay(amount);
    }
}
