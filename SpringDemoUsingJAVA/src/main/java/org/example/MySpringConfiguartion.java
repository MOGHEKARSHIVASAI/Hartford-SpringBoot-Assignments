package org.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySpringConfiguartion {
    @Bean
    public String getMessage(){
        return "Hello World";
    }

    @Bean
    public HelloService getHelloService(String getMessage){
        return new HelloService(getMessage);
    }

    @Bean(name = "upiPayment")
    public PaymentService getUpiPayment(){
        return new UPIPaymentService();
    }

    @Bean(name = "debitCardPayment")
    public PaymentService getDebitCardPayment(){
        return new DebitCardPaymentService();
    }

    @Bean(name = "creditCardPayment")
    public PaymentService getCreditCardPayment(){
        return new CreditCardPaymentService();
    }

    @Bean(name = "emailNotification")
    public NotificationService getEmailNotification(){
        return new EmailNotificationService();
    }

    @Bean(name = "smsNotification")
    public NotificationService getSmsNotification(){
        return new SMSNotificationService();
    }

    @Bean(name = "pushNotification")
    public NotificationService getPushNotification(){
        return new PushNotificationService();
    }

    @Bean(name = "upiWithEmail")
    public ExpenseTracker getUpiWithEmail(
            @Qualifier("upiPayment") PaymentService paymentService,
            @Qualifier("emailNotification") NotificationService notificationService) {
        ExpenseTracker tracker = new ExpenseTracker(paymentService);
        tracker.setNotificationService(notificationService);
        return tracker;
    }

    @Bean(name = "upiWithSms")
    public ExpenseTracker getUpiWithSms(
            @Qualifier("upiPayment") PaymentService paymentService,
            @Qualifier("smsNotification") NotificationService notificationService) {
        ExpenseTracker tracker = new ExpenseTracker(paymentService);
        tracker.setNotificationService(notificationService);
        return tracker;
    }

    @Bean(name = "upiWithPush")
    public ExpenseTracker getUpiWithPush(
            @Qualifier("upiPayment") PaymentService paymentService,
            @Qualifier("pushNotification") NotificationService notificationService) {
        ExpenseTracker tracker = new ExpenseTracker(paymentService);
        tracker.setNotificationService(notificationService);
        return tracker;
    }

    @Bean(name = "debitWithEmail")
    public ExpenseTracker getDebitWithEmail(
            @Qualifier("debitCardPayment") PaymentService paymentService,
            @Qualifier("emailNotification") NotificationService notificationService) {
        ExpenseTracker tracker = new ExpenseTracker(paymentService);
        tracker.setNotificationService(notificationService);
        return tracker;
    }

    @Bean(name = "debitWithSms")
    public ExpenseTracker getDebitWithSms(
            @Qualifier("debitCardPayment") PaymentService paymentService,
            @Qualifier("smsNotification") NotificationService notificationService) {
        ExpenseTracker tracker = new ExpenseTracker(paymentService);
        tracker.setNotificationService(notificationService);
        return tracker;
    }

    @Bean(name = "debitWithPush")
    public ExpenseTracker getDebitWithPush(
            @Qualifier("debitCardPayment") PaymentService paymentService,
            @Qualifier("pushNotification") NotificationService notificationService) {
        ExpenseTracker tracker = new ExpenseTracker(paymentService);
        tracker.setNotificationService(notificationService);
        return tracker;
    }

    @Bean(name = "creditWithEmail")
    public ExpenseTracker getCreditWithEmail(
            @Qualifier("creditCardPayment") PaymentService paymentService,
            @Qualifier("emailNotification") NotificationService notificationService) {
        ExpenseTracker tracker = new ExpenseTracker(paymentService);
        tracker.setNotificationService(notificationService);
        return tracker;
    }

    @Bean(name = "creditWithSms")
    public ExpenseTracker getCreditWithSms(
            @Qualifier("creditCardPayment") PaymentService paymentService,
            @Qualifier("smsNotification") NotificationService notificationService) {
        ExpenseTracker tracker = new ExpenseTracker(paymentService);
        tracker.setNotificationService(notificationService);
        return tracker;
    }

    @Bean(name = "creditWithPush")
    public ExpenseTracker getCreditWithPush(
            @Qualifier("creditCardPayment") PaymentService paymentService,
            @Qualifier("pushNotification") NotificationService notificationService) {
        ExpenseTracker tracker = new ExpenseTracker(paymentService);
        tracker.setNotificationService(notificationService);
        return tracker;
    }
}
