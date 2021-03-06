package com.akshay.service;

import java.util.List;

import com.akshay.dao.CategoryDAO;
import com.akshay.exception.ServiceException;
import com.akshay.exception.ValidationException;
import com.akshay.model.Article;
import com.akshay.model.Category;
import com.akshay.validator.CategoryValidator;

public class CategoryService {
	CategoryDAO dao = new CategoryDAO();
	CategoryValidator categoryValidator = new CategoryValidator();

	public int saveService(Category category) throws ServiceException {
		try {
			categoryValidator.validateSave(category);
			return dao.save(category);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int updateService(Category category) throws ServiceException {
		try {
			categoryValidator.validateUpdate(category);
			return dao.update(category);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int deleteService(int id) throws ServiceException {
		try {
			categoryValidator.validateDelete(id);
			return dao.delete(id);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Category> listService() {
		return dao.list();
	}

	public List<Category> listCategoryService() {
		return dao.listCategory();
	}

	public List<Category> listByUserIdService(int userId) {
		return dao.listByUserId(userId);
	}

	public List<Article> viewByCategoryService(String categoryName) {
		return dao.viewByCategory(categoryName);
	}

	public void insertCategory(Article article, Category category) throws ServiceException {
		try {
			categoryValidator.validateSave(category);
			dao.insertCategory(article, category);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}
}
