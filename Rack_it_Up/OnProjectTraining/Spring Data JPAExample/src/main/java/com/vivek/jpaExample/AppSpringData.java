package com.vivek.jpaExample;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppSpringData {
	
	private static EmployeeRepository repository;
	static EntityManager entityManager = null;
	
	public static void main(String[] args) {
	
		List<Employee> empdata = null;
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        repository = context.getBean(EmployeeRepository.class);
        
		createStudent("Kaushik Pal", "Nation Star", new String[]{"9003663527", "7010231417"}, new String[]{"JAVA", "ANGULARJs"});
		createStudent("Partho", "CTS", new String[]{"9994444988", "7010231417"}, new String[]{"JAVA", "ORACLE"});
		
		System.out.println("!============Saved Completed===================!");
		
		
		
		System.out.println("!============Find By ID===================!");
		
		
		Employee emp1 = null;
		emp1 = repository.findOne((long) 21);
		
		System.out.println(emp1.getName());
		
		System.out.println("!===============================!");
		
		empdata = repository.findByContactList_MobileNo("7010231417");
		System.out.println("!============Find By Contacts===================!");
		System.out.println(empdata);

		for (Employee emp : empdata) {
			
			System.out.println(emp.getName());
		
		}
		System.out.println("!===============================!");
		
		System.out.println("!============Find By Technology===================!");
		
		empdata = repository.findByTechList_TechnologyName("JAVA");
		System.out.println(empdata);
		for (Employee emp : empdata) {
			
			System.out.println(emp.getName());
		
		}
		System.out.println("!============Completed===================!");
	}

	public static void createStudent(String name, String dom, String[] phNos, String[] tech) {
		List<Employee> empList = new ArrayList<Employee>();
		Employee emp = new Employee();
		emp.setName(name);

		Domain domain = new Domain();
		domain.setDomaintName((dom));
		emp.setDomain((domain));

		List<Contacts> contactList = new ArrayList<Contacts>();
		for (String phNo : phNos) {
			Contacts contact1 = new Contacts();
			contact1.setMobileNo(phNo);
			contact1.setEmployee((emp));
			contactList.add(contact1);
		}
		emp.setContactList(contactList);

		List<Technology> techList = new ArrayList<Technology>();
		for (String techString : tech) {
			Technology techno = new Technology();
			techno.setTechnologyName(techString);
			techno.setEmpList((empList));
			techList.add(techno);
		}
		emp.setTechList((techList));
		
		repository.save(emp);
		
	}
	
}
