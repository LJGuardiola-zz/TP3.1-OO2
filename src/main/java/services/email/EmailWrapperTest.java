package services.email;

import model.interfaces.EmailService;

public class EmailWrapperTest implements EmailService {

    private String email;

    @Override
    public void send(String address, String subject, String content) {
        email += address + " | " + subject + " | " + content + "\n";
    }

    public boolean verify(String email) {
        return this.email.contains(email);
    }

}
