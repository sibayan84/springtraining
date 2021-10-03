package com.learn.spring.springjpademo.dao;

import org.springframework.stereotype.Component;

import com.learn.spring.springjpademo.entities.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Component
public class ProductDao {

	@PersistenceContext
	private EntityManager em;
	
	public void persist(Product product) {
		em.persist(product);
	}

	public List<Product> findAll() {
		return em.createQuery("SELECT p FROM Product p").getResultList();
	}
	
	public Product findById(int id) {
		TypedQuery<Product> query = em.createQuery("FROM Product p where p.id=:id",Product.class);
		query.setParameter("id", id);	
		Product result=query.getSingleResult();
		Manufacturer mf=result.getManufacturer();
		System.out.println(mf.getName());
		return result;
	}
	
	public List<Product> findByName(String name) {
		TypedQuery<Product> query = em.createQuery("FROM Product p where p.name=:name",Product.class);
		query.setParameter("name", name);		
		return query.getResultList();
	}

}
