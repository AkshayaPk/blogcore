package com.akshay.service;

import java.util.List;

import com.akshay.dao.ArticleCategoryDAO;
import com.akshay.exception.ServiceException;
import com.akshay.exception.ValidationException;
import com.akshay.model.ArticleCategory;
import com.akshay.validator.ArticleCategoryValidator;

//Comments
public class ArticleCategoryService {
	ArticleCategoryDAO dao = new ArticleCategoryDAO();
	ArticleCategoryValidator articleCategoryValidator = new ArticleCategoryValidator();

	public int saveService(ArticleCategory articleCategory) throws ServiceException {
		try {
			articleCategoryValidator.validateSave(articleCategory);
			return dao.save(articleCategory);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int updateService(ArticleCategory articleCategory) throws ServiceException {
		try {
			articleCategoryValidator.validateUpdate(articleCategory);
			return dao.update(articleCategory);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int deleteService(int id) throws ServiceException {
		try {
			articleCategoryValidator.validateDelete(id);
			return dao.delete(id);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<ArticleCategory> listService() {
		return dao.list();
	}
}
