package com.akshay.validator;

import static com.akshay.util.ValidationUtil.isInvalidInteger;
import static com.akshay.util.ValidationUtil.isInvalidString;

import com.akshay.exception.ValidationException;
import com.akshay.model.Role;

public class RoleValidator {
	public void validateSave(Role role) throws ValidationException {
		isInvalidString(role.getRoleName(), "Invalid name");
	}

	public void validateUpdate(Role role) throws ValidationException {
		isInvalidString(role.getRoleName(), "Invalid name");
		isInvalidInteger(role.getId(), "Invalid user id");
	}

	public void validateDelete(int id) throws ValidationException {
		isInvalidInteger(id, "Invalid id");
	}
}
