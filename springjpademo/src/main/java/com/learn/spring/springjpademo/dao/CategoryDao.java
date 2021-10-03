package com.learn.spring.springjpademo.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.learn.spring.springjpademo.entities.Category;
import com.learn.spring.springjpademo.entities.Manufacturer;
import com.learn.spring.springjpademo.entities.Product;

@Component
public class CategoryDao {
    
	@PersistenceContext
	private EntityManager em;

	public void persist(Category category) {
		em.persist(category);
	}
	
	public void update(Category category) {
		em.merge(category);
	}
	

	public Category findById(int id) {
		TypedQuery<Category> query = em.createQuery("FROM Category c where c.id=:id", Category.class);
		query.setParameter("id", id);
		Category c= query.getSingleResult();
		Set<Product> products=c.getProducts();
		return c;
	}

	public List<Manufacturer> findAll() {
		TypedQuery<Manufacturer> query = em.createQuery("FROM Manufacturer", Manufacturer.class);
		return query.getResultList();
	}
}
