package com.spring.cloud.productcatalog.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.spring.cloud.productcatalog.exception.CatalogException;
import com.spring.cloud.productcatalog.pojo.Product;

@Service
public class ProductService {

	private static final Logger logger = Logger.getLogger(ProductService.class.getName());

	private List<Product> products = new ArrayList<>();
	private int productIDCounter = 0;

	public ProductService() {

	}

	@PostConstruct
	public void init() {
		// Default Products
		products.add(new Product(1, "BritaniaMarie-100gm", "Biscuits"));
		products.add(new Product(2, "Dove-100gm", "Soap"));
		products.add(new Product(3, "Noodles", "Eatarie"));
		products.add(new Product(4, "CoaCola-1l", "Beverages"));
		products.add(new Product(5, "CoaCola-2l", "Beverages"));
		productIDCounter = 5;
	}

	public List<Product> searchProducts() {
		logger.info("Entered searchProducts..");
		// search DB
		return products;
	}

	public Product searchProducts(int id) {
		logger.info("Entered searchProducts for id..");
		// search DB
		for (Product eachProduct : products) {
			if (eachProduct.getProductID() == id) {
				return eachProduct;
			}
		}
		return null;
	}

	public void createProduct(Product product) {
		logger.info("Entered createProduct..");
		if (product.getProductID() == 0) {
			product.setProductID(++productIDCounter);
		}
		this.products.add(product);
	}

	public void updateProduct(Product product) {
		logger.info("Entered updateProduct...");
		boolean found=false;
		for (Product eachProduct : products) {
			if (eachProduct.getProductID() == product.getProductID()) {
				eachProduct.setProductName(product.getProductName());
				eachProduct.setType(product.getType());
				found=true;
				break;
			}
		}
		if(!found) {
			throw new CatalogException("11","Product Not Found");
		}
	}

}
