package com.craft.livingcraft.dao;

import java.util.List;

import com.craft.livingcraft.model.Category;

public interface CategoryDAO {
	
	public void addCategory(Category category);
	public List<Category> getCategoryList();
	public Category getCategoryById(int categoryId);
	public void deleteCategory(int categoryId);
	public Category getCategoryByName(String categoryName);
	public String getJsonList();

}
