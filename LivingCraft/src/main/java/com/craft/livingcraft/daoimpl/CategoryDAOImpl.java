package com.craft.livingcraft.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.craft.livingcraft.dao.CategoryDAO;
import com.craft.livingcraft.model.Category;
import com.google.gson.Gson;

@Repository
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	public void addCategory(Category category) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}
	
	public List<Category> getCategoryList() 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Category> categoryList = session.createQuery("from Category").getResultList();
		return categoryList;
	}

	public Category getCategoryById(int categoryId) 
	{	
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Category> categoryList = session.createQuery("from Category where categoryId = " + categoryId).getResultList();
		return categoryList.get(0);
	}
	
	public void deleteCategory(int categoryId) 
	{
		Category categoryDelete = new Category();
		categoryDelete.setCategoryId(categoryId);
		sessionFactory.getCurrentSession().delete(categoryDelete);
	}
	public Category getCategoryByName(String categoryName) 
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List <Category> categoryList = session.createQuery("from Category where categoryName = " + "'" + categoryName + "'").getResultList();
		return categoryList.get(0);
	}

	public String getJsonList() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Category> categoryList = session.createQuery("from Category").getResultList();
		Gson gson=new Gson();
		String jsonList=gson.toJson(categoryList);
		return jsonList;
		
	}
	
}
