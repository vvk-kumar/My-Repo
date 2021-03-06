package com.vivek.jpaSpecs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.domain.Specification;

public class App {

	public static UserRepository userRepo;

	static Iterable<Userspec> userdata;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");

		userRepo = context.getBean(UserRepository.class);

		Userspec filter = new Userspec();
		filter.setLastName("Kumar");
		filter.setAge(24);
		Specification<Userspec> spec = new UserSpecs(filter);

		userdata = userRepo.findAll(spec);
		long usercount = userRepo.count();

		System.out.println(usercount);
		System.out.println(userdata);
		for (Userspec user1 : userdata) {
			System.out.println(user1.getFirstName() +" "+ user1.getLastName()+" "+ user1.getAge());
		}

	}

}
