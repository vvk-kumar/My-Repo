package com.vivek.jpaExample;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	
	
	@Id
	@SequenceGenerator(name = "EMPLOYEESEQUENCEID", sequenceName = "EMPLOYEESEQUENCE")
	@GeneratedValue(generator = "EMPLOYEESEQUENCEID")
	@Column(name = "EMPLOYEE_ID")
	private Long empId;
	
	@Column(name = "EMPLOYEE_NAME")
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "DOMAIN_ID", foreignKey = @ForeignKey(name = "DOMAIN_ID_FK"))
	private Domain domain;
	
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Contacts> contactList;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "EMPLOYEE_TECH", joinColumns = { @JoinColumn(name = "EMPLOYEE_ID") }, inverseJoinColumns = { @JoinColumn(name = "TECHNOLOGY_ID") })
	private List<Technology> techList;

	
	
	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	
	public List<Contacts> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contacts> contactList) {
		this.contactList = contactList;
	}

	public List<Technology> getTechList() {
		return techList;
	}

	public void setTechList(List<Technology> techList) {
		this.techList = techList;
	}
	
}
