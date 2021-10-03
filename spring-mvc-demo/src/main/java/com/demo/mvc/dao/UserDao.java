package com.demo.mvc.dao;

import java.util.List;

import com.demo.mvc.model.User;

public interface UserDao {

	User findById(Integer id);

	List<User> findAll();

	void save(User user);

	void update(User user);

	void delete(Integer id);

}