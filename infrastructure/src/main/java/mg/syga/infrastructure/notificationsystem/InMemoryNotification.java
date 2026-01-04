package mg.syga.infrastructure.notificationsystem;

import jakarta.enterprise.context.ApplicationScoped;
import mg.syga.campaign.spi.Notification;

@ApplicationScoped
public class InMemoryNotification implements Notification {

    @Override
    public void sendSMS(String phoneNumber, String message) {
        System.out.println("SMS sent. Phone : " + phoneNumber + " | Message : " + message);
    }

    @Override
    public void sendEmail(String email, String subject, String body) {
        System.out.println("Email sent. Email : " + email + " | Subject : " + subject + " | Message : " + body);
    }
}
