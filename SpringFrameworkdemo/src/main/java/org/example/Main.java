package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

        Scanner sc=new Scanner(System.in);
        System.out.println("Select Payment Service");
        System.out.println("1. UPI Payment");
        System.out.println("2. Credit Card Payment");
        System.out.println("3. Debit Card Payment");
        System.out.print("Enter your payment choice (1-3): ");

        int paymentChoice=sc.nextInt();

        if(paymentChoice < 1 || paymentChoice > 3){
            System.out.println("Invalid payment choice! Exiting...");
            sc.close();
            System.exit(0);
        }

        // Step 2: Choose Notification Service
        System.out.println("Select Notification Service");
        System.out.println("1. Email Notification");
        System.out.println("2. WhatsApp Notification");
        System.out.println("3. SMS Notification");
        System.out.print("Enter your notification choice (1-3): ");

        int notificationChoice=sc.nextInt();

        if(notificationChoice < 1 || notificationChoice > 3){
            System.out.println("Invalid notification choice! Exiting...");
            sc.close();
            System.exit(0);
        }

        int beanIndex = (paymentChoice - 1) * 3 + notificationChoice;

        ExpenseTracker ep=null;
        MessageTracker mt=null;
        switch(beanIndex){
            case 1:
                ep=(ExpenseTracker) context.getBean("expenseTracker1");
                mt=(MessageTracker) context.getBean("messageTracker1");
                break;
            case 2:
                ep=(ExpenseTracker) context.getBean("expenseTracker2");
                mt=(MessageTracker) context.getBean("messageTracker2");
                break;
            case 3:
                ep=(ExpenseTracker) context.getBean("expenseTracker3");
                mt=(MessageTracker) context.getBean("messageTracker3");
                break;
            case 4:
                ep=(ExpenseTracker) context.getBean("expenseTracker4");
                mt=(MessageTracker) context.getBean("messageTracker4");
                break;
            case 5:
                ep=(ExpenseTracker) context.getBean("expenseTracker5");
                mt=(MessageTracker) context.getBean("messageTracker5");
                break;
            case 6:
                ep=(ExpenseTracker) context.getBean("expenseTracker6");
                mt=(MessageTracker) context.getBean("messageTracker6");
                break;
            case 7:
                ep=(ExpenseTracker) context.getBean("expenseTracker7");
                mt=(MessageTracker) context.getBean("messageTracker7");
                break;
            case 8:
                ep=(ExpenseTracker) context.getBean("expenseTracker8");
                mt=(MessageTracker) context.getBean("messageTracker8");
                break;
            case 9:
                ep=(ExpenseTracker) context.getBean("expenseTracker9");
                mt=(MessageTracker) context.getBean("messageTracker9");
                break;
        }

        // Display selected configuration
        String[] payments = {"UPI", "Credit Card", "Debit Card"};
        String[] notifications = {"Email", "WhatsApp", "SMS"};
        System.out.println("Selected Configuration");
        System.out.println("Payment: " + payments[paymentChoice-1]);
        System.out.println("Notification: " + notifications[notificationChoice-1]);

        System.out.println("Processing Payment");
        ep.payRent(5000);
        ep.rechargeMobile(999);

        System.out.println("Sending Notifications");
        mt.sendHelloMessage("Hello, this is a message from MessageTracker!");
        mt.sendGoodbyeMessage("Goodbye, this is a message from MessageTracker!");

        sc.close();
    }
}