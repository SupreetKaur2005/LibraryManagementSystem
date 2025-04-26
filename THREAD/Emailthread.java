package thread;

import util.EmailUtil;

public class EmailThread extends Thread {

    private String recipient;
    private String subject;
    private String body;

    public EmailThread(String recipient, String subject, String body) {
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    @Override
    public void run() {
        try {
            EmailUtil.sendEmail(recipient, subject, body);
        } catch (Exception e) {
            e.printStackTrace();  // Log error
        }
    }
}
