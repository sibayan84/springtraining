package com.demo.mvc.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.mvc.model.AppUser;
import com.demo.mvc.model.Manufacturer;

@Repository
public class AppUsersDaoImpl {

	private final Logger logger = Logger.getLogger(AppDaoImpl.class.getName());

	@Autowired
	@Qualifier("jtemplate_users")
	NamedParameterJdbcTemplate jtemplate;

	public AppUser findByUsername(String userName) {
		logger.info("Inside findManufacturerById..");

		String sql = "select * FROM app_users WHERE username=:userName";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);

		AppUser appUser = null;
		try {
			appUser = jtemplate.queryForObject(sql, params, new AppUsersMapper());
		} catch (EmptyResultDataAccessException e) {
			logger.severe("User "+userName+" login attempt failed. Not in DB");
		}

		return appUser;

	}

}
