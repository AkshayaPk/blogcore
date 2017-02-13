package com.akshay.validator;

import static com.akshay.util.ValidationUtil.isInvalidInteger;
import static com.akshay.util.ValidationUtil.isInvalidString;

import com.akshay.exception.ValidationException;
import com.akshay.model.Article;

public class ArticleValidator {
	private static final String INVALID_USER_ID = "Invalid user id";
	private static final String INVALID_CONTENT = "Invalid content";
	private static final String INVALID_TITLE = "Invalid title";

	public void validateSave(Article article) throws ValidationException {
		isInvalidInteger(article.getUserId().getId(), INVALID_USER_ID);
		isInvalidString(article.getTitle(), INVALID_TITLE);
		isInvalidString(article.getContent(), INVALID_CONTENT);
	}

	public void validateUpdate(Article article, String title) throws ValidationException {
		isInvalidInteger(article.getUserId().getId(), INVALID_USER_ID);
		isInvalidString(article.getTitle(), INVALID_TITLE);
		isInvalidString(article.getContent(), INVALID_CONTENT);
		isInvalidString(title, "Invalid Old title");
	}

	public void validateUpdateById(Article article) throws ValidationException {
		isInvalidInteger(article.getId(), "Invalid article id");
		isInvalidString(article.getTitle(), INVALID_TITLE);
		isInvalidString(article.getContent(), INVALID_CONTENT);
	}

	public void validateDelete(int id) throws ValidationException {
		isInvalidInteger(id, "Invalid id");
	}

	public void validateListByUser(int id) throws ValidationException {
		isInvalidInteger(id, INVALID_USER_ID);
	}
}
