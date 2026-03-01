package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MySpringConfiguartion.class);
        ExpenseTracker expenseTracker = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Expense Tracker Payment System");


        System.out.println("Please select your payment method:");
        System.out.println("  1. UPI Payment");
        System.out.println("  2. Debit Card Payment");
        System.out.println("  3. Credit Card Payment");
        System.out.print("Enter your choice: ");
        int paymentChoice = sc.nextInt();

        System.out.println("How would you like to receive notifications?");
        System.out.println("  1. Email Notification");
        System.out.println("  2. SMS Notification");
        System.out.println("  3. Push Notification");
        System.out.print("Enter your choice: ");
        int notificationChoice = sc.nextInt();

        String beanName = getBeanName(paymentChoice, notificationChoice);

        if (beanName != null) {
            expenseTracker = ctx.getBean(beanName, ExpenseTracker.class);
            System.out.println("Your payment system is ready!");


            expenseTracker.payRent(5000);
            expenseTracker.payElectricityBill(1400);
            expenseTracker.payWaterBill(2000);
            expenseTracker.payInternetBill(1500);


            System.out.println("All payments have been processed successfully!");
        } else {
            System.out.println("Invalid choice! Please run the program again.");
        }

        sc.close();
    }

    private static String getBeanName(int paymentChoice, int notificationChoice) {
        String paymentType = "";
        String notificationType = "";

        switch (paymentChoice) {
            case 1: paymentType = "upi"; break;
            case 2: paymentType = "debit"; break;
            case 3: paymentType = "credit"; break;
            default: return null;
        }

        switch (notificationChoice) {
            case 1: notificationType = "Email"; break;
            case 2: notificationType = "Sms"; break;
            case 3: notificationType = "Push"; break;
            default: return null;
        }

        return paymentType + "With" + notificationType;
    }
}