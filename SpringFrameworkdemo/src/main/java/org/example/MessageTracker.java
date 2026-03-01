package org.example;

public class MessageTracker {
    private NotificationService notificationService;
    public MessageTracker(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public MessageTracker() {
    }



    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendHelloMessage(String message){
        notificationService.sendNotification(message);
    }
    public void sendGoodbyeMessage(String message){
        notificationService.sendNotification(message);
    }
}
