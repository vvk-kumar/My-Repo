package com.vivek.jpaExample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

public class EmployeeRepoImp implements EmployeeRepo{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Employee> findByContactList_MobileNo(String mobileNo) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> employeeCriteria = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> employeeRoot = employeeCriteria.from(Employee.class);
		Join<Employee, Contacts> employeeContactsJoin = employeeRoot.join("contactList", JoinType.INNER);
		employeeCriteria.select(employeeRoot).where(criteriaBuilder.equal(employeeContactsJoin.get("mobileNo"), mobileNo));
		TypedQuery<Employee> employeeQuery = entityManager.createQuery(employeeCriteria);
		return employeeQuery.getResultList();
	}

	
	@Override
	public List<Employee> findByTechList_TechnologyName(String technologyName) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> employeeCriteria = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> employeeRoot = employeeCriteria.from(Employee.class);
		Join<Employee, Technology> techJoin = employeeRoot.join("techList", JoinType.INNER);
		employeeCriteria.select(employeeRoot).where(criteriaBuilder.equal(techJoin.get("technologyName"), technologyName));
		TypedQuery<Employee> employeeQuery = entityManager.createQuery(employeeCriteria);
		
		return employeeQuery.getResultList();
		
	}


}
