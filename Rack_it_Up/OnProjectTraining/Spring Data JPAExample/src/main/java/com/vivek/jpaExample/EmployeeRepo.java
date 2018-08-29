package com.vivek.jpaExample;

import java.util.List;

public interface EmployeeRepo {

	List<Employee> findByContactList_MobileNo(String mobileNo);

	List<Employee> findByTechList_TechnologyName(String technologyName);
}
