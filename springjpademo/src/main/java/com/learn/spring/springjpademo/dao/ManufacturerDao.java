package com.learn.spring.springjpademo.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.learn.spring.springjpademo.entities.Manufacturer;
import com.learn.spring.springjpademo.entities.Product;

@Component
public class ManufacturerDao {

	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	public void persist(Manufacturer manufacturer) {
		em.persist(manufacturer);
	}
	
	public void update(Manufacturer manufacturer) {
		em.merge(manufacturer);
	}
	

	public Manufacturer findById(int id) {
		TypedQuery<Manufacturer> query = em.createQuery("FROM Manufacturer m where m.id=:id", Manufacturer.class);
		query.setParameter("id", id);
		Manufacturer m= query.getSingleResult();
		Set<Product> products=m.getProducts();
		return m;
	}
	
	public Manufacturer findByCode(String manufacturerCode) {
		TypedQuery<Manufacturer> query = em.createQuery("FROM Manufacturer m where m.code=:code", Manufacturer.class);
		query.setParameter("code", manufacturerCode);
		Manufacturer m= query.getSingleResult();
		System.out.println("Fetching Products with Manufacturer");
		Set<Product> products=m.getProducts();
		if(products!=null) {
			System.out.println("Successfully Fetched Product Count "+products.size());
		}
		return m;
	}

	public List<Manufacturer> findAll() {
		TypedQuery<Manufacturer> query = em.createQuery("FROM Manufacturer", Manufacturer.class);
		return query.getResultList();
	}
}
