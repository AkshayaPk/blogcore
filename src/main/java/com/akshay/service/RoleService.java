package com.akshay.service;

import java.util.List;

import com.akshay.dao.RoleDAO;
import com.akshay.exception.ServiceException;
import com.akshay.exception.ValidationException;
import com.akshay.model.Role;
import com.akshay.validator.RoleValidator;

public class RoleService {
	RoleDAO dao = new RoleDAO();
	RoleValidator roleValidator = new RoleValidator();

	public int saveService(Role role) throws ServiceException {
		try {
			roleValidator.validateSave(role);
			return dao.save(role);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int updateService(Role role) throws ServiceException {
		try {
			roleValidator.validateUpdate(role);
			return dao.update(role);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int deleteService(int id) throws ServiceException {
		try {
			roleValidator.validateDelete(id);
			return dao.delete(id);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Role> listService() {
		return dao.list();
	}
}
