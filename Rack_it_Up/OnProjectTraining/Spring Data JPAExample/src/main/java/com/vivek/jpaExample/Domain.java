package com.vivek.jpaExample;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "DOMAIN_VIVEK")
public class Domain {

	@Id
	@SequenceGenerator(name = "DOMAINSEQUENCEID", sequenceName = "DOMAINSEQUENCE")
	@GeneratedValue(generator = "DOMAINSEQUENCEID")
	@Column(name="DOMAIN_ID")
	private Long departmentId;
	
	
	@Column(name="DOMAIN_NAME")
	private String domaintName;
	
	@OneToMany(mappedBy="domain", fetch=FetchType.LAZY)
	private List<Employee> empList;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDomaintName() {
		return domaintName;
	}

	public void setDomaintName(String domaintName) {
		this.domaintName = domaintName;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	
	
}
