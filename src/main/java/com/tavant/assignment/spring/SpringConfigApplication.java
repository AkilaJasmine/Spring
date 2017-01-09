package com.tavant.assignment.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringConfigApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SpringApplication springObj = (SpringApplication) context.getBean("springApp");
		springObj.doAddAndMultiply();
	}

}
