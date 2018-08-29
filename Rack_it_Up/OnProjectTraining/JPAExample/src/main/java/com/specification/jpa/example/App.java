package com.specification.jpa.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
			
		
		ApplicationContext context = new ClassPathXmlApplicationContext("jpa_config.xml");
	   
			
		UserRepository userspec = (UserRepository) context.getBean("dataSourceJPA");
		
		System.out.println(userspec.findAll());

	}

	
}
