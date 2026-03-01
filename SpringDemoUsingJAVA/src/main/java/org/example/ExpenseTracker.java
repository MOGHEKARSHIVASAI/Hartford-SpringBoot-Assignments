package org.example;

public class ExpenseTracker {
    private PaymentService ps;
    private NotificationService ns;

    public ExpenseTracker(PaymentService ps){
        this.ps=ps;
    }

    public void setNotificationService(NotificationService ns) {
        this.ns = ns;
    }

    public void payRent(double amount){
        System.out.println("\nProcessing rent payment of Rs." + amount);
        ps.pay(amount);
        if(ns != null) {
            ns.sendNotification("Your rent payment of Rs." + amount + " was successful");
        }
    }

    public void payElectricityBill(double amount){
        System.out.println("\nProcessing electricity bill of Rs." + amount);
        ps.pay(amount);
        if(ns != null) {
            ns.sendNotification("Your electricity bill of Rs." + amount + " has been paid");
        }
    }

     public void payWaterBill(double amount){
        System.out.println("\nProcessing water bill of Rs." + amount);
        ps.pay(amount);
        if(ns != null) {
            ns.sendNotification("Your water bill of Rs." + amount + " has been paid");
        }
    }

     public void payInternetBill(double amount){
        System.out.println("\nProcessing internet bill of Rs." + amount);
        ps.pay(amount);
        if(ns != null) {
            ns.sendNotification("Your internet bill of Rs." + amount + " has been paid");
        }
    }
}
