package com.craft.livingcraft.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Supplier {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplierId;
	@NotEmpty(message="*Name is Compulsory")
	private String supplierName;
	@NotEmpty(message="*Address is Compulsory")
	private String supplierAddress;
//	@NotEmpty(message="*Contact is Compulsory")
	private int supplierContact;
	
	
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public int getSupplierContact() {
		return supplierContact;
	}
	public void setSupplierContact(int supplierContact) {
		this.supplierContact = supplierContact;
	}
	
	

}

