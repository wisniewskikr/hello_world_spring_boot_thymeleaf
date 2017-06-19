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
	
	
	private static final String TEMPLATE_NAME = "emails/template";
	private static final String FROM = "wisniewskikr@gmail.com";
	private static final String TO = "krzysztof.wisniewski@contractors.roche.com";
	private static final String SUBJECT = "Subject";
	private static final boolean IS_HTML = true;


    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private TemplateEngine templateEngine;
    
    
    public void sendHelloWorldEmail(String name) {
    	
    	Map<String, Object> customProperties = new HashMap<String, Object>();
    	customProperties.put("name", name);
    	
    	sendHtmlEmail(customProperties);
    	
    }
    
    public void sendHtmlEmail(Map<String, Object> customProperties) {
        final Context context = new Context();

        if (!MapUtils.isEmpty(customProperties)) {
            context.setVariables(customProperties);
        }
        final String htmlBody = templateEngine.process(TEMPLATE_NAME, context);
        sendEmail(FROM, TO, SUBJECT, htmlBody, IS_HTML);
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
