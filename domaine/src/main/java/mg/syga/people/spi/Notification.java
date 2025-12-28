package mg.syga.people.spi;

public interface Notification {
    void sendSMS(String phoneNumber, String message);
    void sendEmail(String email, String subject, String body);
}
