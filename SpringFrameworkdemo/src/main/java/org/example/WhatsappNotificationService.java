package org.example;

public class WhatsappNotificationService implements NotificationService{
    @Override
    public void sendNotification(String message) {
        System.out.println("Message: "+message+" was sent to "+" using Whatsaap Message Service!!!");
    }
}
