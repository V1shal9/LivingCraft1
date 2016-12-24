package com.craft.livingcraft.config;


import java.io.IOException;
import java.util.Properties;
 
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.craft.livingcraft.daoimpl.CategoryDAOImpl;
import com.craft.livingcraft.daoimpl.ProductDAOImpl;
import com.craft.livingcraft.daoimpl.SubCategoryDAOImpl;
import com.craft.livingcraft.model.Category;
import com.craft.livingcraft.model.Product;
import com.craft.livingcraft.model.SubCategory;
import com.craft.livingcraft.model.Supplier;
import com.craft.livingcraft.services.CategoryService;
import com.craft.livingcraft.services.ProductService;
import com.craft.livingcraft.services.SubCategoryService;


 
@Configuration
@EnableTransactionManagement
@ComponentScan( "com.craft" )


public class HibernateConfig {

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/LivingCraft");
        dataSource.setUsername("vishal");
        dataSource.setPassword("");
        
        Properties dproperties= new Properties();
        dproperties.setProperty("hibernate.show_sql", "true");
        dproperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        dproperties.setProperty("hibernate.hbm2ddl.auto","update");
     
        return dataSource;
    }
     
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto","update");
        return properties;
    }
    
    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(
            SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(
                sessionFactory);
     
        return transactionManager;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
     
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.addProperties(getHibernateProperties());
     
        sessionBuilder.addAnnotatedClasses(Category.class);
        sessionBuilder.addAnnotatedClasses(Supplier.class);
        sessionBuilder.addAnnotatedClasses(SubCategory.class);
        sessionBuilder.addAnnotatedClasses(Product.class);


        return sessionBuilder.buildSessionFactory();
    }

  
    @Autowired
    @Bean(name = "categoryDAOImpl")
    public CategoryDAOImpl getCategoryDao(SessionFactory sessionFactory) {
    	return new CategoryDAOImpl(sessionFactory);
    }
   
    @Autowired
    @Bean(name="categoryService")
    public CategoryService getCategoryService() {
    	return new CategoryService();
    }

    
    
    
//    @Autowired
//    @Bean(name = "supplierDAOImpl")
//    public SupplierDAOImpl getSupplierDao(SessionFactory sessionFactory) {
//    	return new SupplierDAOImpl(sessionFactory);
//    }
//    
//    @Autowired
//    @Bean(name="supplierService")
//    public SupplierService getSupplierService() {
//    	return new SupplierService();
//    }

    
    @Autowired
    @Bean(name = "subCategoryDAOImpl")
    public SubCategoryDAOImpl getSubCategoryDao(SessionFactory sessionFactory) {
    	return new SubCategoryDAOImpl(sessionFactory);
    }
   
    @Autowired
    @Bean(name="subCategoryService")
    public SubCategoryService getSubCategoryService() {
    	return new SubCategoryService();
    }
   
  
    @Autowired
   @Bean(name = "productDAOImpl")
    public ProductDAOImpl getProductDao(SessionFactory sessionFactory) {
    	return new ProductDAOImpl(sessionFactory);
    }
    
    @Autowired
    @Bean(name="productService")
    public ProductService getProductService() {
    	return new ProductService();
    }
    
    @Autowired
    @Bean(name="multipartResolver")
    public CommonsMultipartResolver getResolver() throws IOException
    {
    	CommonsMultipartResolver resolver= new CommonsMultipartResolver();
    	resolver.setDefaultEncoding("utf-8");
    	return resolver;
    }
    
    

}