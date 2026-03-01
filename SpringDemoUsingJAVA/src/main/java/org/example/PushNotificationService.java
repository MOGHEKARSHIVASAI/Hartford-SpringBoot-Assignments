package org.example;

public class PushNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Push notification sent: " + message);
    }
}

