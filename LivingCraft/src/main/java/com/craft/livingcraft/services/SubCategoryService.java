package com.craft.livingcraft.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.craft.livingcraft.daoimpl.SubCategoryDAOImpl;
import com.craft.livingcraft.model.SubCategory;


@Service
@Transactional
public class SubCategoryService {
	
	@Autowired
	SubCategoryDAOImpl subCategoryDAOImpl;

	public void addSubCategory(SubCategory subCategory)
	{
		subCategoryDAOImpl.addSubCategory(subCategory);
	}
	public List<SubCategory> getSubCategoryList()
	{
		return subCategoryDAOImpl.getSubCategoryList();
	}
	public SubCategory getSubCategoryById(int subCategoryId)
	{
		return subCategoryDAOImpl.getSubCategoryById(subCategoryId);
	}
	public void deleteSubCategory(int subCategoryId)
	{
		subCategoryDAOImpl.deleteSubCategory(subCategoryId);
	}
	
	public SubCategory getSubCategoryByName(String subCategoryName)
	{
		return subCategoryDAOImpl.getSubCategoryByName(subCategoryName);
	}
	
	public String getJsonList()
	{
		return subCategoryDAOImpl.getJsonList();

	}	


	
	
}
