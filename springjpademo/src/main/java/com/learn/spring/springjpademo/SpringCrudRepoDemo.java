package com.learn.spring.springjpademo;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.spring.springjpademo.entities.Manufacturer;
import com.learn.spring.springjpademo.service.JPAService;
import com.learn.spring.springjpademo.service.ManufacturerCrudRepositoryService;

public class SpringCrudRepoDemo {
	
	public static void main(String[] args) {
		
		System.out.println("Entered SrpingCrudRepoDemo....");
		
		SpringCrudRepoDemo demo = new SpringCrudRepoDemo();

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application-ctx.xml");
		
		System.out.println("Application Context Loaded successfully.. ");
		
		ManufacturerCrudRepositoryService mfCrudService = context.getBean(ManufacturerCrudRepositoryService.class);
		
		System.out.println("ManufacturerCrudRepositoryService in context is "+mfCrudService);
		
		//demo.findManufacturerById(mfCrudService);
		//demo.findManufacturerByCode(mfCrudService);
		//demo.addManufacturer(mfCrudService);
		demo.findManufacturerByEmailAndPhone(mfCrudService);
		//demo.deleteManufacturer(mfCrudService);
		
		context.close();
	}
	
	public void findManufacturerById(ManufacturerCrudRepositoryService mfCrudService) {
		System.out.println("Entered findManufacturerById");
		Integer id=1;
		Manufacturer m1=mfCrudService.findById(1);
		System.out.println("Manufacturer details : "+m1);
		/*if(m1!=null) {
			if(m1.getProducts()!=null) {
				System.out.println("Product Count for this manufacturer : "+m1.getProducts().size());
			}
		}*/
	}
	
	public void findManufacturerByCode(ManufacturerCrudRepositoryService mfCrudService) {
		System.out.println("Entered findManufacturerByCode");
		String code="CC";
		Manufacturer m1=mfCrudService.findByCode(code);
		System.out.println("Manufacturer details : "+m1);
	}
	
	public void findManufacturerByEmailAndPhone(ManufacturerCrudRepositoryService mfCrudService) {
		System.out.println("Entered findManufacturerByAddressAndPhone");
		String email="contact@asus.com";
		String phone="123123123";
		List<Manufacturer> mfList=mfCrudService.findByEmailAndPhone(email,phone);
		if(mfList!=null) {
			System.out.println("Manufacturer count : "+mfList.size());
			for(Manufacturer each:mfList) {
				System.out.println("Manufacturer :"+each);
			}
		}else {
			System.out.println("Manufacturer List null");
		}
	}
	
	public void addManufacturer(ManufacturerCrudRepositoryService mfCrudService) {
		System.out.println("Entered addManufacturer");
		Manufacturer m1=new Manufacturer("PP","Pepsi", "Dalla", "contact@pepsi.com", "789789789");
		mfCrudService.add(m1);
		System.out.println("Successfully Added Manufacturer");
	}
	
	public void deleteManufacturer(ManufacturerCrudRepositoryService mfCrudService) {
		System.out.println("Entered deleteManufacturer");
		Integer idToDelete=14;
		mfCrudService.deleteById(idToDelete);
		System.out.println("Successfully Deleted Manufacturer");
	}

}
