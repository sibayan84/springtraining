package com.demo.mvc.dao;

import java.util.List;

import com.demo.mvc.model.Category;
import com.demo.mvc.model.Manufacturer;
import com.demo.mvc.model.Product;
import com.demo.mvc.model.User;

public interface AppDao {

	Manufacturer findManufacturerById(Integer id);
	Category findCategoryById(Integer id);
	Product findProductById(Integer id);

	List<Manufacturer> findAllManufacturer();
	List<Category> findAllCategory();
	List<Product> findAllProduct();

	void saveManufacturer(Manufacturer manufacturer);
	void saveCategory(Category category);
	void saveProduct(Product product);

	void updateManufacturer(Manufacturer manufacturer);
	void updateCategory(Category category);
	void updateProduct(Product product);
	
	void deleteManufacturer(Integer id);
	void deleteCategory(Integer id);
	void deleteProduct(Integer id);
	
}