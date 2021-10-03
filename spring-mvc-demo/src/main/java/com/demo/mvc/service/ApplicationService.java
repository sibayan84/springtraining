package com.demo.mvc.service;

import java.util.List;

public interface ApplicationService<T> {
	public T findById(Integer id);

	public List<T> findAll();

	public void saveOrUpdate(T t);

	public void delete(int id);
}
