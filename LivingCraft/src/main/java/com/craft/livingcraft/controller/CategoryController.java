package com.craft.livingcraft.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.craft.livingcraft.model.Category;
import com.craft.livingcraft.services.CategoryService;



@Controller
public class CategoryController 
{
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/category")
	public String category(Model model)
	{
		model.addAttribute("category", new Category());
	//	model.addAttribute("categoryList", categoryService.getCategoryList());
		model.addAttribute("categoryList", categoryService.getJsonList());
		return "/category";
	}
	
	@RequestMapping("/addCategory")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, Model model)
	{ if(bindingResult.hasErrors())
	 {
		model.addAttribute("categoryList", categoryService.getJsonList());
        return "category";
	 }
	else 
	 {
		categoryService.addCategory(category);
		return "redirect:/category";
	 }
	}
	
	@RequestMapping("/editCategory-{categoryId}")
	public String getCategoryById(@PathVariable("categoryId") int categoryId, Model model)
	{
		model.addAttribute("category", categoryService.getCategoryById(categoryId));
		return "/category";
	}
	
	@RequestMapping("/deleteCategory-{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") int categoryId)
	{
		categoryService.deleteCategory(categoryId);
		return "redirect:/category";
	}
}
