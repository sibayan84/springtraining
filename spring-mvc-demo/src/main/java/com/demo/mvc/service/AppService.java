package com.demo.mvc.service;

import java.util.List;

import com.demo.mvc.model.Category;
import com.demo.mvc.model.Manufacturer;
import com.demo.mvc.model.Product;
import com.demo.mvc.model.User;

public interface AppService {

	public Manufacturer findManufacturerById(Integer id);
	public Category findCategoryById(Integer id);
	public Product findProductById(Integer id);
	
	public List<Manufacturer> findAllManufacturer();
	public List<Category> findAllCategory();
	public List<Product> findAllProduct();

	public void saveOrUpdate(Manufacturer m);
	public void saveOrUpdate(Category c);
	public void saveOrUpdate(Product p);
	
	public void deleteManufacturer(int id);
	public void deleteCategory(int id);
	public void deleteProduct(int id);
	
}