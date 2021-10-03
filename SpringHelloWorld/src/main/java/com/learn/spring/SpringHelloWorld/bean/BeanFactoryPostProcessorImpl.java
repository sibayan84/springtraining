package com.learn.spring.SpringHelloWorld.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BeanFactoryPostProcessorImpl implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		System.out.println("In postProcessBeanFactory");
		// Getting the bean address 
		BeanDefinition bd = beanFactory.getBeanDefinition("address");
		if (bd.hasPropertyValues()) {
			MutablePropertyValues pvs = bd.getPropertyValues();
			PropertyValue[] pvArray = pvs.getPropertyValues();
			for (PropertyValue pv : pvArray) {
				System.out.println("pv -- " + pv.getName());
				// changing value for url property
				if (pv.getName().equals("country")) {
					pvs.add(pv.getName(), "DominicanRepublic");
				}
			}
		}

	}

}
