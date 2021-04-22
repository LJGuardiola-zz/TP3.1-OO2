package model.interfaces;

public interface EmailService {
    void send(String address, String subject, String content);
}
