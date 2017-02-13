package com.akshay.validator;

import static com.akshay.util.ValidationUtil.isInvalidInteger;

import com.akshay.exception.ValidationException;
import com.akshay.model.ArticleCategory;

public class ArticleCategoryValidator {
	public void validateSave(ArticleCategory articleCategory) throws ValidationException {
		isInvalidInteger(articleCategory.getArticleId().getId(), "Invalid Article Id");
		isInvalidInteger(articleCategory.getCategoryId().getId(), "Invalid Category Id");
	}

	public void validateUpdate(ArticleCategory articleCategory) throws ValidationException {
		isInvalidInteger(articleCategory.getArticleId().getId(), "Invalid Article Id");
		isInvalidInteger(articleCategory.getCategoryId().getId(), "Invalid Category Id");
		isInvalidInteger(articleCategory.getId(), "Invalid id");
	}

	public void validateDelete(int id) throws ValidationException {
		isInvalidInteger(id, "Invalid id");
	}
}
