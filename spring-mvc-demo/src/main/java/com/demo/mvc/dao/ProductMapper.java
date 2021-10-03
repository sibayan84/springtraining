package com.demo.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.mvc.model.Category;
import com.demo.mvc.model.Manufacturer;
import com.demo.mvc.model.Product;
import com.demo.mvc.utils.AppUtils;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product p = new Product();
		p.setId(rs.getInt("id"));
		p.setCode(rs.getString("code"));
		p.setName(rs.getString("name"));
		p.setDesc(rs.getString("description"));
		p.setWeight(rs.getString("weight"));
		p.setPkgdt(rs.getString("pkgdt"));
		p.setExpirydt(rs.getString("expirydt"));
		p.setMrp(AppUtils.toString(rs.getFloat("mrp")));
		p.setDiscount(AppUtils.toString(rs.getFloat("discount")));
		p.setOfferPrice(AppUtils.toString(rs.getFloat("offerprice")));
		p.setStock(AppUtils.toString(rs.getInt("stock")));
		
		Category c=new Category();
		c.setId(rs.getInt("category_id"));
		c.setName(rs.getString("category_name"));
		p.setCategory(c);
		
		Manufacturer m=new Manufacturer();
		m.setId(rs.getInt("manufacturer_id"));
		m.setName(rs.getString("manufacturer_name"));
		p.setManufacturer(m);
		
		return p;
	}

}
