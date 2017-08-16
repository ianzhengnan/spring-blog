package com.ian.sblog.service;

import java.util.List;

import com.ian.sblog.domain.Category;

public interface CategoryService {

	void createCategory(Category category);
	
	void updateCategory(Category category);
	
	void deleteCategory(Integer id);
	
	List<Category> getCategoriesByUser(Integer id);
}
