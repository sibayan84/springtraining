package com.learn.spring.springjpademo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.spring.springjpademo.entities.Category;
import com.learn.spring.springjpademo.entities.Manufacturer;
import com.learn.spring.springjpademo.entities.Product;
import com.learn.spring.springjpademo.service.JPAService;

public class SpringJPADemo {

	public static void main(String[] args) {

		System.out.println("Entered  SpringJPADemo@main  .. ");

		SpringJPADemo demo = new SpringJPADemo();

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application-ctx.xml");
		
		System.out.println("Application Context Loaded successfully.. ");
		
		JPAService jpaService = context.getBean(JPAService.class);
		
		System.out.println("JPAService in context is "+jpaService);

		//demo.addManufacturersOneByOne(jpaService);
		demo.findManufacturersByCode(jpaService);
		//demo.addProductOnly(jpaService);

		context.close();
	}

	
	public void addProductOnly(JPAService jpaService) {
		System.out.println("Entered  addProductOnly  .. ");
		
		int associatedCategoryId=1;
		int associatedManufacturerId=1;
		
		Product p=new Product();
		p.setCode("AZ6x");
		p.setName("Zenphone6x");
		p.setDesc("smart phone");
		p.setBatch("AZ1299");
		p.setPackageDate(new Date());
		p.setMrp(new Float(3000));
		p.setDiscount(new Float(10));
		p.setOfferprice(new Float(2700));
		
		jpaService.addProductOnly(p, associatedCategoryId, associatedManufacturerId);
		
		System.out.println("Product addedd successfully...");
		
	}
	
	
	public void addProductWithCategoryAndManufaturer(JPAService jpaService) {
		System.out.println("Entered  addProductWithCategoryAndManufaturer  .. ");
		Manufacturer m1=new Manufacturer("AS","Asus", "Denever", "contact@asus.com", "123123123");
		Category c=new Category("MOB001","electronics","mobile");
		Product p=new Product();
		p.setCode("AZ5");
		p.setName("Zenphone5x");
		p.setDesc("smart phone");
		p.setBatch("AZ1298");
		p.setPackageDate(new Date());
		p.setMrp(new Float(2000));
		p.setDiscount(new Float(5));
		p.setOfferprice(new Float(1900));
		p.setManufacturer(m1);
		p.setCategory(c);
		//jpaService.addProductOnly(p, 3, 4);
		jpaService.addProduct(p);
		System.out.println("Category, Manufacturer and Product addedd successfully...");
		
	}
	
	public void addManufacturers(JPAService jpaService) {
		System.out.println("Entered  addManufacturers  .. ");
		Manufacturer m1=new Manufacturer("AL","AlkatelLucent", "Atlanta", "contact@al.com", "44444");
		Manufacturer m2=new Manufacturer("HW","Huawei", "Shanghai", "contact@huawei.com", "552552");
		Manufacturer m3=new Manufacturer("HW","Huawei", "Shanghai", "contact@huawei.com", "552552");
		List<Manufacturer> mList=new ArrayList();
		mList.add(m1);
		mList.add(m2);
		mList.add(m3);
		jpaService.addAllManufacturer(mList);
	}
	
	public void addManufacturersOneByOne(JPAService jpaService) {
		System.out.println("Entered  addManufacturersOneByOne  .. ");
		Manufacturer m1=new Manufacturer("AL","AlkatelLucent", "Atlanta", "contact@al.com", "44444");
		Manufacturer m2=new Manufacturer("HW","Huawei", "Shanghai", "contact@huawei.com", "552552");
		Manufacturer m3=new Manufacturer("HW","Huawei", "Shanghai", "contact@huawei.com", "552552");
		jpaService.addManufacturer(m1);
		jpaService.addManufacturer(m2);
		jpaService.addManufacturer(m3);
	}
	
	public void findManufacturersByCode(JPAService jpaService) {
		System.out.println("Entered  findManufacturersByCode  .. ");
		String manufacturerCode="HUL";
		Manufacturer m=jpaService.findManufacturerByCode(manufacturerCode);
		System.out.println("Manufacturer : "+m);
		if(m!=null) {
			if(m.getProducts()!=null) {
				System.out.println("Number of Products for this Manufacturer : "+m.getProducts().size());
				for(Product p:m.getProducts()) {
					System.out.println("Product "+p);
					System.out.println("Category "+p.getCategory());
				}
			}
			
		}
	}

}
