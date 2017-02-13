package com.akshay.service;

import java.util.List;

import com.akshay.dao.CommentDAO;
import com.akshay.exception.ServiceException;
import com.akshay.exception.ValidationException;
import com.akshay.model.Comment;
import com.akshay.validator.CommentValidator;

public class CommentService {
	CommentDAO dao = new CommentDAO();
	CommentValidator commentValidator = new CommentValidator();

	public int saveService(Comment comment) throws ServiceException {
		try {
			commentValidator.validateSave(comment);
			return dao.save(comment);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int updateService(Comment comment) throws ServiceException {
		try {
			commentValidator.validateUpdate(comment);
			return dao.update(comment);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int deleteService(int id) throws ServiceException {
		try {
			commentValidator.validateDelete(id);
			return dao.delete(id);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Comment> listService() {
		return dao.list();
	}

	public List<Comment> listByArticleIdService(int articleId) {
		return dao.listByArticleId(articleId);
	}
}
