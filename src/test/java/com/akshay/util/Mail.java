package com.akshay.util;

import org.apache.commons.mail.EmailException;

import com.akshay.model.Comment;
import com.akshay.model.User;
import com.akshay.util.MailUtil;

public class Mail {public static void main(String[] args) {
	Comment comment=new Comment();
comment.setCommentText("adkjhfkajlsdhfklasdd");
User user=new User();
user.setEmailId("ragav87@ymail.com");
user.setUserName("Ragavan");
comment.setUserId(user);
	try {
		MailUtil.sendSimpleMail(comment);
	} catch (EmailException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

}
