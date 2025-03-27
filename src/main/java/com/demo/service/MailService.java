package com.demo.service;

import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.demo.model.User;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

	private JavaMailSender javaMailSender;

	public MailService(JavaMailSender javaMailSender) {
		super();
		this.javaMailSender = javaMailSender;
	}

	public void mailSending(User user) {

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

		simpleMailMessage.setTo(user.getEmailAddress());
		simpleMailMessage.setSubject("Spring boot-Mail send");
		simpleMailMessage.setText("Congratulation!you got mail from spring boot application");

		javaMailSender.send(simpleMailMessage);
	}

	public void sendEmailWithAttachment(String to, String subject, String body, String filePath) {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

			messageHelper.setTo(to);
			messageHelper.setSubject(subject);
			messageHelper.setText(body);

			FileSystemResource systemResource = new FileSystemResource(new File(filePath));
			messageHelper.addAttachment(systemResource.getFilename(), systemResource);
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
