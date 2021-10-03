package com.demo.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.mvc.model.Category;
import com.demo.mvc.model.Manufacturer;

public class CategoryMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category c = new Category();
		c.setId(rs.getInt("id"));
		c.setCode(rs.getString("name"));
		c.setName(rs.getString("name"));
		c.setDesc(rs.getString("description"));
		return c;
	}

}
