package com.akshay.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.akshay.model.Comment;
import com.akshay.model.User;

public class MailUtil {
	private MailUtil() {

	}

	public static void sendSimpleMail(Comment comments) throws EmailException {
		Email email = new SimpleEmail();
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("ashpeekay23@gmail.com", "ashraypk"));
		email.setDebug(false);
		email.setHostName("smtp.gmail.com");
		email.setSSLOnConnect(true);
		email.setFrom("ashpeekay23@gmail.com");// Admin email
		email.setSubject(comments.getUserId().getId() +" commented on your article");
		email.setMsg(comments.getCommentText());
		email.addTo(comments.getUserId().getEmailId());
		email.setStartTLSEnabled(true);
		email.send();

	}
	public static void sendActivationMail(User user) throws EmailException {
		Email email = new SimpleEmail();
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("ashpeekay23@gmail.com", "ashraypk"));
		email.setDebug(false);
		email.setHostName("smtp.gmail.com");
		email.setSSLOnConnect(true);
		email.setFrom("ashpeekay23@gmail.com");// Admin email
		email.setSubject("Blog Management System");
		email.setMsg("Use the following url to activate the account "+" http://localhost:8080/users/activate?userName="+user.getUserName()+"&code="+user.getActivationCode());
		email.addTo(user.getEmailId());
		email.setStartTLSEnabled(true);
		email.send();

	}

}
