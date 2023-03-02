package com.app.service;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.app.pojos.Manager;

@Service
@Transactional
public class MailServiceImpl implements IMailService 
{
	
	@Autowired
	private JavaMailSender javamailsender;
	
	@Override
	public void sendMail(Manager man)
	{
		try
		{
			MimeMessage message = javamailsender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setFrom("pushpdantpatil14@gmail.com");
			helper.setTo(man.getEmail());
			String text = "Hello "+man.getFirstName()+"Welcome To FitnessClub";
			helper.setText(text);
			javamailsender.send(message);
			
		}catch(Exception e)
		{
			
		}
	}

}
