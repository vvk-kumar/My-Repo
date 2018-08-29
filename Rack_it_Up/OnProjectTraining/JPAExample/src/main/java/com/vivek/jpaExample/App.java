package com.vivek.jpaExample;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;


public class App {

	static EntityManager entityManager = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mavenJPA");
		entityManager = entityManagerFactory.createEntityManager();
		
		createStudent("Vivek Kumar", "CANALI", new String[]{"9003663527", "7010231417"}, new String[]{"JAVA", "DOTNET"});
		createStudent("Ramki", "CANALI", new String[]{"9994444988", "7010231417"}, new String[]{"JAVA", "DOTNET"});
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		String mobileNo = "9994444988";
		CriteriaQuery<Employee> empcriteria = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> studentRoot = empcriteria.from(Employee.class);
		Join<Employee, Contacts> studentContactJoin = studentRoot.join("contactList", JoinType.INNER);
		empcriteria.select(studentRoot).where(criteriaBuilder.equal(studentContactJoin.get("mobileNo"), mobileNo));
		TypedQuery<Employee> empquery = entityManager.createQuery(empcriteria);
		System.out.println("\n\n For given MobileNo(" + mobileNo
				+ ")  EmpID is "
				+ empquery.getSingleResult().getEmpId()
				+ "  EmpName is "
				+ empquery.getSingleResult().getName());

		
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
		
		entityManager.getTransaction().begin();
		entityManager.persist(emp);
		entityManager.getTransaction().commit();

		System.out.println(emp);
	}
	
}
