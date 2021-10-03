package com.demo.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.mvc.model.Manufacturer;

public class ManufacturerMapper implements RowMapper<Manufacturer> {

	@Override
	public Manufacturer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Manufacturer m = new Manufacturer();
		m.setId(rs.getInt("id"));
		m.setCode(rs.getString("code"));
		m.setName(rs.getString("name"));
		m.setEmail(rs.getString("email"));
		m.setAddress(rs.getString("address"));
		m.setPhone(rs.getString("phone"));
		return m;
	}

}
