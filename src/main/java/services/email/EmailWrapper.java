package services.email;

import model.interfaces.EmailService;
import services.email.lib.Email;
import services.email.lib.SmtpException;

public class EmailWrapper implements EmailService {

    @Override
    public void send(String address, String subject, String content) {
        try {
            new Email(address, subject, content).enviar();
        } catch (SmtpException e) {
            throw new RuntimeException("No se pudo enviar el email a " + address, e);
        }
    }

}
