package com.akshay.model;

import lombok.Data;

@Data
public class Category {
	private int id;
	private String name;
	private User userId;
}
