package ua.com.shop.serviceImpl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import ua.com.shop.service.MailSendingService;

@Service
public class MailSendingServiceImpl implements MailSendingService {

	@Override
	public void sendMail(String content, String email, String mailBody) {

		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.setProperty("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		Session session = Session.getDefaultInstance(properties,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("lyubamoroz3@gmail.com", "morozla1996");
					}
				});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("lyubamoroz3@gmail.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					email));
			message.setSubject(content, "UTF-8");
			message.setText(mailBody);
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
