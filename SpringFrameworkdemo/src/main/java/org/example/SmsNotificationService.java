package org.example;

public class SmsNotificationService implements NotificationService{
    @Override
    public void sendNotification(String message) {
        System.out.println("SMS notification sent with message: "+message);
    }
}

