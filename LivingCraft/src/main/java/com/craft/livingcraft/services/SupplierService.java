package com.craft.livingcraft.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.craft.livingcraft.daoimpl.SupplierDAOImpl;
import com.craft.livingcraft.model.Supplier;


@Service
@Transactional
public class SupplierService {
	
	@Autowired
	SupplierDAOImpl supplierDAOImpl;

	
	public void addSupplier(Supplier supplier)
	{
		supplierDAOImpl.addSupplier(supplier);
	}
	
	public List<Supplier> getSupplierList()
	{
	return	supplierDAOImpl.getSupplierList();
	}
	public Supplier getSupplierById(int supplierId)
	{
		return supplierDAOImpl.getSupplierById(supplierId);
	}
	public void deleteSupplier(int supplierId)
	{
		supplierDAOImpl.deleteSupplier(supplierId);
	}

	public Supplier getSupplierByName(String supplierName) {
		return supplierDAOImpl.getSupplierByName(supplierName);

	}
	public String getJsonList()
	{
		return supplierDAOImpl.getJsonList();
	}

	
	
}

