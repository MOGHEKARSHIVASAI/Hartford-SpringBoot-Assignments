package org.example;

public class EmailNotificationService implements NotificationService{
    @Override
    public void sendNotification(String message) {
        System.out.println("Email notification sent with message: "+message);
    }
}
