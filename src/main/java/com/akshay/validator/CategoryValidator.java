package com.akshay.validator;

import static com.akshay.util.ValidationUtil.*;

import com.akshay.exception.ValidationException;
import com.akshay.model.Category;

public class CategoryValidator {
	public void validateSave(Category category) throws ValidationException {
		isInvalidString(category.getName(), "Invalid name");
		isInvalidInteger(category.getUserId().getId(), "Invalid user id");
	}

	public void validateUpdate(Category category) throws ValidationException {
		isInvalidString(category.getName(), "Invalid name");
		isInvalidInteger(category.getUserId().getId(), "Invalid user id");
	}

	public void validateDelete(int id) throws ValidationException {
		isInvalidInteger(id, "Invalid id");
	}
}
