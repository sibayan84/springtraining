package com.learn.spring.annotationdemo.jpa.entity;

//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan
//@EntityScan
//@EnableJpaRepositories
public class JPADemo2 {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JPADemo2.class);
		String[] beans=ctx.getBeanDefinitionNames();
		
		/*ManufacturerRepository repo = (ManufacturerRepository)ctx
				  .getBean(ManufacturerRepository.class);*/
		Manufacturer mf = (Manufacturer)ctx
				  .getBean(Manufacturer.class);
		/*HelloBeanMisc misc = (HelloBeanMisc)ctx
				  .getBean(HelloBeanMisc.class);*/
		
		
		/*JPADemo1 jpaDemo1 = (JPADemo1)ctx
				  .getBean(JPADemo1.class);*/
		
		/*Manufacturer manufacturer=new Manufacturer();
		manufacturer.setName("PECIndustries");
		manufacturer.setEmail("contact@pec.com");
		manufacturer.setPhone("112233445566");
		manufacturer.setAddress("51 Lee Road, Delhi");
		repo.save(manufacturer);*/
		
		//Manufacturer mf=repo.findById(1);
		//System.out.println(mf);
		
		//System.out.println(jpaDemo1.getManufaturer());
		
	}

}
