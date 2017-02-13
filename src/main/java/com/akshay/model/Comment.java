package com.akshay.model;

import lombok.Data;

@Data
public class Comment {
	private int id;
	private Article articleId;
	private User userId;
	private String commentText;
}
