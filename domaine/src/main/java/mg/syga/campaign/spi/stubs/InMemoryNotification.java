package mg.syga.campaign.spi.stubs;

import mg.syga.campaign.spi.Notification;

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
