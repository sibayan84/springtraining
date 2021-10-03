package com.demo.mvc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.demo.mvc.model.Category;
import com.demo.mvc.model.Manufacturer;
import com.demo.mvc.model.Product;

@Repository
public class AppDaoImpl implements AppDao {
	
	private final Logger logger = LoggerFactory.getLogger(AppDaoImpl.class);
	
	@Autowired
	@Qualifier("jtemplate_product")
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Manufacturer findManufacturerById(Integer id) {
		logger.info("Inside findManufacturerById..");

		String sql = "SELECT * FROM Manufacturer WHERE id=:id";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		Manufacturer result = null;
		try {
			result = namedParameterJdbcTemplate.queryForObject(sql, params, new ManufacturerMapper());
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public List<Manufacturer> findAllManufacturer() {
		logger.info("Inside findAllManufacturer..");
		
		String sql = "SELECT * FROM manufacturer";
		List<Manufacturer> result = namedParameterJdbcTemplate.query(sql, new ManufacturerMapper());
		System.out.println("----findAll Manufaturer----" + result);
		return result;

	}

	@Override
	public void saveManufacturer(Manufacturer m) {
		logger.info("Inside saveManufacturer..");
		
		// keyholder will contain the autogenerated key returned from jdbc template
		// update method
		KeyHolder keyHolder = new GeneratedKeyHolder();

		String sql = "INSERT INTO MANUFACTURER(code, name, address,email,phone) " + "VALUES (:code, :name,:address,:email, :phone)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(m), keyHolder);
		m.setId(keyHolder.getKey().intValue());

	}

	@Override
	public void updateManufacturer(Manufacturer m) {
		logger.info("Inside updateManufacturer..");
		
		String sql = "UPDATE MANUFACTURER SET CODE=:code, NAME=:name, EMAIL=:email, ADDRESS=:address, PHONE=:phone"
				+ " WHERE id=:id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(m));

	}

	@Override
	public void deleteManufacturer(Integer id) {
		logger.info("Inside deleteManufacturer..");

		String sql = "DELETE FROM Manufacturer WHERE id= :id";
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));

	}

	// Category
	@Override
	public Category findCategoryById(Integer id) {
		logger.info("Inside findCategoryById..");

		String sql = "SELECT * FROM Category WHERE id=:id";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		Category result = null;
		try {
			result = namedParameterJdbcTemplate.queryForObject(sql, params, new CategoryMapper());
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public List<Category> findAllCategory() {
		logger.info("Inside findAllCategory..");
		
		String sql = "SELECT * FROM category";
		List<Category> result = namedParameterJdbcTemplate.query(sql, new CategoryMapper());
		System.out.println("----findAll Category----" + result);
		return result;

	}

	@Override
	public void saveCategory(Category c) {
		logger.info("Inside saveCategory..");
		// keyholder will contain the autogenerated key returned from jdbc template
		// update method
		KeyHolder keyHolder = new GeneratedKeyHolder();

		String sql = "INSERT INTO Category(code, name, description) " + "VALUES (:code,:name,:desc)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(c), keyHolder);
		c.setId(keyHolder.getKey().intValue());

	}

	@Override
	public void updateCategory(Category c) {
		logger.info("Inside updateCategory..");
		
		String sql = "UPDATE Category SET CODE=:code, NAME=:name, description=:desc" + " WHERE id=:id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(c));
	}

	@Override
	public void deleteCategory(Integer id) {
		logger.info("Inside deleteCategory..");
		String sql = "DELETE FROM Category WHERE id= :id";
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));
	}

	// Product
	@Override
	public Product findProductById(Integer id) {
		logger.info("Inside findProductById..");
		
		String sql = "select p.*,  c.name as category_name, m.name as manufacturer_name from Product p, Category c, manufacturer m"
				+ " where p.category_id=c.id" + " and p.manufacturer_id=m.id" + " and p.id= :id";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		Product result = null;
		try {
			result = namedParameterJdbcTemplate.queryForObject(sql, params, new ProductMapper());
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public List<Product> findAllProduct() {
		logger.info("Inside findAllProduct..");

		String sql = "select p.*,  c.name as category_name, m.name as manufacturer_name from Product p, Category c, manufacturer m"
				+ " where p.category_id=c.id" + " and p.manufacturer_id=m.id";
		List<Product> result = namedParameterJdbcTemplate.query(sql, new ProductMapper());
		System.out.println("----findAll Product----" + result);
		return result;

	}

	@Override
	public void saveProduct(Product p) {
		logger.info("Inside saveProduct..");
		// keyholder will contain the autogenerated key returned from jdbc template
		// update method
		KeyHolder keyHolder = new GeneratedKeyHolder();

		String sql = "INSERT INTO PRODUCT(code,name, description,weight, pkgdt, expirydt, mrp, discount, offerprice, stock, category_id, manufacturer_id) "
				+ " VALUES (:code, :name,:description, :weight, :pkgdt, :expirydt, :mrp, :discount, :offerprice, :stock, :category_id, :manufacturer_id)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(p), keyHolder);
		p.setId(keyHolder.getKey().intValue());

	}

	@Override
	public void updateProduct(Product p) {
		logger.info("Inside updateProduct..");

		String sql = "UPDATE Product SET CODE=:code, NAME=:name, description=:description, weight=:weight, pkgdt=:pkgdt, expirydt=:expirydt, mrp=:mrp, discount=:discount"
		             + " offerprice=:offerprice, stock=:stock, category_id=:category_id, manufacturer_id=:manufacturer_id"
		             + " WHERE id=:id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(p));

	}

	@Override
	public void deleteProduct(Integer id) {
		logger.info("Inside deleteProduct..");
		String sql = "DELETE FROM Product WHERE id= :id";
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));
	}

	private SqlParameterSource getSqlParameterByModel(Manufacturer m) {
		logger.info("Inside getSqlParameterByModel for manufacturer..");
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", m.getId());
		paramSource.addValue("code", m.getCode());
		paramSource.addValue("name", m.getName());
		paramSource.addValue("email", m.getEmail());
		paramSource.addValue("address", m.getAddress());
		paramSource.addValue("phone", m.getPhone());
		return paramSource;
	}

	private SqlParameterSource getSqlParameterByModel(Category c) {
		logger.info("Inside getSqlParameterByModel for Category..");
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", c.getId());
		paramSource.addValue("code", c.getCode());
		paramSource.addValue("name", c.getName());
		paramSource.addValue("desc", c.getDesc());
		return paramSource;
	}

	private SqlParameterSource getSqlParameterByModel(Product p) {
		logger.info("Inside getSqlParameterByModel for Product..");
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", p.getId());
		paramSource.addValue("code", p.getCode());
		paramSource.addValue("name", p.getName());
		paramSource.addValue("description", p.getDesc());
		paramSource.addValue("weight", p.getWeight());
		paramSource.addValue("pkgdt", p.getPkgdt());
		paramSource.addValue("expirydt", p.getExpirydt());
		paramSource.addValue("mrp", p.getMrp());
		paramSource.addValue("discount", p.getDiscount());
		paramSource.addValue("offerprice", p.getOfferPrice());
		paramSource.addValue("stock", p.getStock());

		paramSource.addValue("category_id", p.getCategory().getId());
		paramSource.addValue("manufacturer_id", p.getManufacturer().getId());

		return paramSource;
	}

}