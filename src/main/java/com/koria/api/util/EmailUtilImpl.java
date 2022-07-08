package com.koria.api.util;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
@Lazy(value = true)
public class EmailUtilImpl implements EmailUtil {

	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${com.koria.api.email.subject}")
	private String EMAIl_SUBJECT;
	@Value("${com.koria.api.email.text}")
	private String ATTACH_TEXT;

	private static Logger LOGGER = LoggerFactory.getLogger(EmailUtilImpl.class);
	@Override
	public void sendEmail(String to, String path) {
		MimeMessage msg = mailSender.createMimeMessage();
		LOGGER.info("Trying to send an email to "+to);
		try {
		    MimeMessageHelper helper = new MimeMessageHelper(msg,true);
			helper.setTo(to);
			helper.setSubject(EMAIl_SUBJECT);
			helper.setText(ATTACH_TEXT);
			helper.addAttachment("Itinerary", new File(path));
			mailSender.send(msg);
		LOGGER.info("Mail sent successfully");
		} catch (Exception e) {
		LOGGER.info("An error occured while trying to send your mail");
		LOGGER.error("ERROR",e.getCause());
		}
		
	}


}
