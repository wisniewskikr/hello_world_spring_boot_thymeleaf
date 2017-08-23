package pl.kwi.springboot.services;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.util.MapUtils;


@Service
public class EmailService {
	
	
	private static final String RESET_TEMPLATE = "emails/reset";
	private static final String REGISTRATION_TEMPLATE = "emails/registration";
	private static final String RESET_SUBJECT = "Reset Email";
	private static final String REGISTRATION_SUBJECT = "Registration Email";
	private static final String FROM = "wisniewskikr@gmail.com";	
	private static final boolean IS_HTML = true;
	private static final String ADMIN_ACCOUNT = "krzysztof.wisniewski@contractors.roche.com";


    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private TemplateEngine templateEngine;
    
    
    public void sendResetEmail(String to, String link) {
    	
    	Map<String, Object> customProperties = new HashMap<String, Object>();
    	customProperties.put("link", link);    	
    	sendHtmlEmail(to, customProperties, RESET_TEMPLATE, RESET_SUBJECT);
    	
    }
    
    public void sendRegistrationEmail(String email) {
    	
    	Map<String, Object> customProperties = new HashMap<String, Object>();
    	customProperties.put("link", "http://localhost:8080/registrationConsole");  
    	customProperties.put("userEmail", email); 
    	sendHtmlEmail(ADMIN_ACCOUNT, customProperties, REGISTRATION_TEMPLATE, REGISTRATION_SUBJECT);
    	
    }
    
    public void sendHtmlEmail(String to, Map<String, Object> customProperties, String template, String subject) {
        final Context context = new Context();

        if (!MapUtils.isEmpty(customProperties)) {
            context.setVariables(customProperties);
        }
        final String htmlBody = templateEngine.process(template, context);
        sendEmail(FROM, to, subject, htmlBody, IS_HTML);
    }

    public void sendEmail(String from, String to, String subject, String text, boolean isHtml) {
        try {
            final MimeMessage mail = mailSender.createMimeMessage();
            final MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setFrom(from);
            helper.setSubject(subject);
            helper.setText(text, isHtml);
            mailSender.send(mail);
        } catch (MessagingException | MailException e) {
        	e.printStackTrace();
            throw new IllegalStateException("Failed to send email to " + to);
        }
    }
    

}
