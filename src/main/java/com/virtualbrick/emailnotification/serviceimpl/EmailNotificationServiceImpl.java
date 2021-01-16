package com.virtualbrick.emailnotification.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.virtualbrick.emailnotification.model.User;

@Service
public class EmailNotificationServiceImpl {

	private JavaMailSender javaMailSender;

	@Autowired
	public EmailNotificationServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	//TODO: Create the table using HTML and append it int .setText method.
	public void sendEmail(User user) throws MailException{
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setSubject("Testing Email Notification API");
		mail.setText("This is a test email. Next email should contain a table with various data");

		javaMailSender.send(mail);
	}
}
