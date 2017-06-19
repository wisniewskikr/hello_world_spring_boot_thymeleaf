package pl.kwi.springboot.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
	
	
	private static final String FROM = "wisniewskikr@gmail.com";
	private static final String TO = "krzysztof.wisniewski@contractors.roche.com";
	private static final String SUBJECT = "Subject";


    @Autowired
    private JavaMailSender mailSender;
    
    
    public void sendHelloWorldEmail(String name) {
    	
    	String text = "Hello World " + name;
    	sendEmail(FROM, TO, SUBJECT, text);
    	
    }

    public void sendEmail(String from, String to, String subject, String text) {
        try {
            final MimeMessage mail = mailSender.createMimeMessage();
            final MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setFrom(from);
            helper.setSubject(subject);
            helper.setText(text);
            mailSender.send(mail);
        } catch (MessagingException | MailException e) {
        	e.printStackTrace();
            throw new IllegalStateException("Failed to send email to " + to);
        }
    }
    

}
