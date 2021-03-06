package com.akshay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.akshay.model.Article;
import com.akshay.model.ArticleCategory;
import com.akshay.model.Category;
import com.akshay.util.ConnectionUtil;

public class ArticleCategoryDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public int save(ArticleCategory articleCategory) {
		String sql = "insert into Article_Category(article_id,category_id)values (?,?)";
		Object[] params = { articleCategory.getArticleId().getId(), articleCategory.getCategoryId().getId() };
		return jdbcTemplate.update(sql, params);
	}

	public int update(ArticleCategory articleCategory) {
		String sql = "update Article_Category set article_id=?,category_id=? where id=?";
		Object[] params = { articleCategory.getArticleId().getId(), articleCategory.getCategoryId().getId() };
		return jdbcTemplate.update(sql, params);
	}

	public int delete(int id) {
		String sql = "delete from Article_Category where article_id=?";
		return jdbcTemplate.update(sql, id);
	}

	public List<ArticleCategory> list() {
		final String sql = "select id,article_id,category_id from Article_Category";
		return jdbcTemplate.query(sql, (rs, rowNum) -> fetchData(rs));
	}

	public List<ArticleCategory> listByCategory(int id) {
		final String sql = "select id,article_id,category_id from Article_Category where category_id=?";
		Object[] params = { id };
		return jdbcTemplate.query(sql, params, (rs, rowNum) -> fetchData(rs));
	}

	private ArticleCategory fetchData(ResultSet rs) throws SQLException {
		final ArticleCategory articleCategory = new ArticleCategory();
		articleCategory.setId(rs.getInt("id"));
		Article article = new Article();
		article.setId(rs.getInt("article_id"));
		articleCategory.setArticleId(article);
		Category category = new Category();
		category.setId(rs.getInt("category_id"));
		articleCategory.setCategoryId(category);
		return articleCategory;
	}
}
