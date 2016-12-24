package com.craft.livingcraft.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.craft.livingcraft.services.SupplierService;
import com.craft.livingcraft.model.Supplier;

@Controller
public class SupplierController {
	@Autowired
	SupplierService supplierService;
	
	@RequestMapping(value = "/supplier")
	   public String supplier(Model model) {
		
		model.addAttribute("supplier",new Supplier());
//		model.addAttribute("supplierList",supplierService.getSupplierList());
		model.addAttribute("supplierList",supplierService.getJsonList());

	
	    return "supplier";
	   }
	
	 @RequestMapping(value = "/addSupplier")
	   public String addSupplier(@Valid @ModelAttribute("supplier")Supplier supplier, BindingResult bindingResult, Model model) {
	     if(bindingResult.hasErrors())
	     {
	    	 model.addAttribute("supplier", supplierService.getJsonList());
	    	 return "supplier";
	     }
	     else
	     {
	      supplierService.addSupplier(supplier);
	      return "redirect:/supplier";
	     }
	   }
	
	 @RequestMapping(value ="editSupplier-{supplierId}")
	   
	   public String editSupplier(Model model,@PathVariable("supplierId") int supplierId)
	   {
		   model.addAttribute("supplier",supplierService.getSupplierById(supplierId));
		   return "supplier";
	   }
	 
	 @RequestMapping(value="deleteSupplier-{supplierId}")
	   public String deleteSupplier(@PathVariable("supplierId") int supplierId)
	   {
		   supplierService.deleteSupplier(supplierId);
		   return "redirect:/supplier";
	   }

	   
	

}

