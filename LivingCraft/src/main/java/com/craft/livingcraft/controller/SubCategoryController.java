package com.craft.livingcraft.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.craft.livingcraft.services.CategoryService;
import com.craft.livingcraft.services.SubCategoryService;
import com.craft.livingcraft.model.Category;
import com.craft.livingcraft.model.SubCategory;



@Controller
public class SubCategoryController {
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/subcategory")
	   public String SubCategory(Model model) {
		
		model.addAttribute("subCategory",new SubCategory());
		model.addAttribute("category", new Category());
//		model.addAttribute("subCategoryList",subCategoryService.getSubCategoryList());
		model.addAttribute("categoryList",categoryService.getCategoryList());

 //   	model.addAttribute("categoryList",categoryService.getJsonList());
		model.addAttribute("subCategoryList",subCategoryService.getJsonList());

	    return "subcategory";   
	   }

	@RequestMapping("/addSubCategory")
	   public String addSubCategory(@Valid @ModelAttribute("subCategory")SubCategory subCategory, BindingResult bindingResult, Model model) 
	{  if(bindingResult.hasErrors())
	{
		model.addAttribute("subCategoryList", subCategoryService.getJsonList());
		return "subcategory";
	}
	else
	{
		Category category = categoryService.getCategoryByName(subCategory.getCategory().getCategoryName());
		subCategory.setCategory(category);
		subCategory.setCategoryId(category.getCategoryId());
		 subCategoryService.addSubCategory(subCategory);
	      return "redirect:/subcategory";
	}
	   }
	
	@RequestMapping(value ="editSubCategory-{subCategoryId}")
	   
	   public String editSubCategory(Model model,@PathVariable("subCategoryId")int subCategoryId)
	   {
		   model.addAttribute("subCategory",subCategoryService.getSubCategoryById(subCategoryId));
		   model.addAttribute("categoryList", categoryService.getCategoryList());
		   return "subcategory";
	   }
	
	 @RequestMapping(value="deleteSubCategory-{subCategoryId}")
	   public String deleteSubCategory(@PathVariable("subCategoryId") int subCategoryId)
	   {
		 subCategoryService.deleteSubCategory(subCategoryId);
		   return "redirect:/subcategory";
	   }

}
