package com.spring.cloud.productcatalog.rest;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.productcatalog.pojo.Product;
import com.spring.cloud.productcatalog.service.ProductService;

@RestController
@RequestMapping(value = "/product/v1")
public class ProductController extends BaseController {

	private static final Logger logger = Logger.getLogger(ProductController.class.getName());

	@Autowired
	private ProductService productService;
	
	@Value("${message.livereload}")
	private String message;

	@RequestMapping(value = "/search", method = RequestMethod.GET,headers = "Accept=application/json,text/xml")
	public @ResponseBody List<Product> searchProduct() {
		logger.info("Entered searchJob");
		return productService.searchProducts();
	}

	@RequestMapping(value = "/search/{id}", method = RequestMethod.GET,produces = {"application/json", "text/xml"})
	public @ResponseBody Product searchProduct(@PathVariable("id") int id) {
		logger.info("Entered searchJob with id");
		return productService.searchProducts(id);
	}

	@RequestMapping(value = "/createProduct", method = RequestMethod.POST)
	public void cteateProduct(@RequestBody Product product,HttpServletRequest request) throws IOException {
		logger.info("Entered cteateProduct " + product);
		logger.info("Request = "+request);
		logger.info("RequestVal = "+request.getParameter("abcd"));
		String input=IOUtils.toString(request.getReader());
		logger.info("Input = "+input);
		productService.createProduct(product);
	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.PUT)
	public void updateProduct(@RequestBody Product product) {
		logger.info("Entered cteateProduct " + product);
		productService.updateProduct(product);
	}
	
	@GetMapping(value = "/liveReload")
	public String hello() {
		return this.message;
	}

}
