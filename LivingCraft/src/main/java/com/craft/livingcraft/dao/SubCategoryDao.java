package com.craft.livingcraft.dao;

import java.util.List;

import com.craft.livingcraft.model.SubCategory;

public interface SubCategoryDao {
	
	public void addSubCategory(SubCategory subCategory);
	public List<SubCategory> getSubCategoryList();
	public SubCategory getSubCategoryById(int subCategoryId);
	public void deleteSubCategory(int subCategoryId);
	public SubCategory getSubCategoryByName(String subCategoryName);
	public String getJsonList();


}


