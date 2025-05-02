package util;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Utility class for sending emails.
 * Requires javax.mail library in the classpath.
 */
public class EmailUtil {

    private static final Logger logger = Logger.getLogger(EmailUtil.class.getName());

    private static final String from;
    private static final String password;
    private static final Properties props = new Properties();
    private static final Session session;

    static {
        from = ConfigLoader.getProperty("email.from");
        password = ConfigLoader.getProperty("email.password");

        String smtpHost = ConfigLoader.getProperty("email.smtp.host");
        String smtpPort = ConfigLoader.getProperty("email.smtp.port");
        String smtpAuth = ConfigLoader.getProperty("email.auth");
        String starttlsEnable = ConfigLoader.getProperty("email.starttls.enable");

        if (from == null || from.isEmpty()) {
            logger.severe("Email 'from' address is not configured properly.");
        }
        if (password == null || password.isEmpty()) {
            logger.severe("Email password is not configured properly.");
        }
        if (smtpHost == null || smtpHost.isEmpty()) {
            logger.severe("SMTP host is not configured properly.");
        }
        if (smtpPort == null || smtpPort.isEmpty()) {
            logger.severe("SMTP port is not configured properly.");
        }
        if (smtpAuth == null || smtpAuth.isEmpty()) {
            logger.warning("SMTP auth property is not set. Defaulting to true.");
            smtpAuth = "true";
        }
        if (starttlsEnable == null || starttlsEnable.isEmpty()) {
            logger.warning("SMTP starttls.enable property is not set. Defaulting to true.");
            starttlsEnable = "true";
        }

        props.put("mail.smtp.auth", smtpAuth);
        props.put("mail.smtp.starttls.enable", starttlsEnable);
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);

        session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
    }

    public static void sendEmail(String to, String subject, String messageText) {
        if (to == null || subject == null || messageText == null) {
            logger.warning("sendEmail called with null parameters");
            return;
        }

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            message.setSubject(subject);
            message.setText(messageText);

            Transport.send(message);
        } catch (MessagingException e) {
            logger.log(Level.SEVERE, "Failed to send email", e);
        }
    }
}
