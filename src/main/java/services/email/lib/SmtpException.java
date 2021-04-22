package services.email.lib;

public class SmtpException extends Exception {
    public SmtpException(String msg) {
        super(msg);
    }
}
