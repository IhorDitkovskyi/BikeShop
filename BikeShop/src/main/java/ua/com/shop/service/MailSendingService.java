package ua.com.shop.service;

public interface MailSendingService {

	void sendMail(String content, String email, String mailBody);
}
