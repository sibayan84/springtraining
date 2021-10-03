package com.demo.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.mvc.model.AppUser;
import com.demo.mvc.model.Manufacturer;

public class AppUsersMapper implements RowMapper<AppUser> {

	@Override
	public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		AppUser appuser = new AppUser();
		appuser.setUsername(rs.getString("username"));
		appuser.setPassword(rs.getString("password"));
		appuser.setRole(rs.getString("role"));
		return appuser;
	}

}
