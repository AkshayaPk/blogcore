package com.akshay.service;

import java.util.List;

import com.akshay.dao.RatingDAO;
import com.akshay.exception.ServiceException;
import com.akshay.exception.ValidationException;
import com.akshay.model.Rating;
import com.akshay.validator.RatingValidator;

public class RatingService {
	RatingDAO dao = new RatingDAO();
	RatingValidator ratingValidator = new RatingValidator();

	public int saveService(Rating rating) throws ServiceException {
		try {
			ratingValidator.validateSave(rating);
			return dao.save(rating);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int updateService(Rating rating) throws ServiceException {
		try {
			ratingValidator.validateUpdate(rating);
			return dao.update(rating);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int deleteService(int id) throws ServiceException {
		try {
			ratingValidator.validateDelete(id);
			return dao.delete(id);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Rating> listService() {
		return dao.list();
	}
}
