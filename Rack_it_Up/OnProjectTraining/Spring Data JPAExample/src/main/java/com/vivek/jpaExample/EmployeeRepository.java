package com.vivek.jpaExample;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long>,EmployeeRepo{
	
	
	
}
