package com.virtualbrick.emailnotification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualbrick.emailnotification.model.User;
import com.virtualbrick.emailnotification.serviceimpl.EmailNotificationServiceImpl;

@RestController
@RequestMapping(path = "/")
public class EmailNotificationController {

	@Autowired
	private User user;

	@Autowired
	private EmailNotificationServiceImpl notificationService;

	@GetMapping(value = "email")
	public void emailNotificationFunction() {
		user.setEmailAddress("surya.sagi7@gmail.com");
		try {
			notificationService.sendEmail(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
	}

}
